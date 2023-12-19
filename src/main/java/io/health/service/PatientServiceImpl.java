package io.health.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.health.dto.ReportResponseDTO;
import io.health.entities.Report;
import io.health.repository.CBCRepos;
import io.health.repository.ReportRespo;
import io.health.service.mapper.Mapping;
import io.health.vo.request.CBCReportVO;
import io.health.vo.request.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.health.config.StatusCodeConfig;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.entities.CBCReport;
import io.health.entities.Patient;
import io.health.exceptions.GeneralException;
import io.health.exceptions.PatientNotFoundException;
import io.health.exceptions.ReportsNotAddedException;
import io.health.repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired(required = true)
    private PatientRepo repo;


    @Autowired(required = true)
    private ReportRespo reportRepo;

    @Autowired(required = true)
    private CBCRepos cbcRepos;

    @Autowired
    private StatusCodeConfig config;

    @Override
    public PatientResponseDto addPatient(PatientRequestDto dto) {
        // TODO Auto-generated method stub
        Patient entity = Mapping.getPatient(dto);
        Patient retrivePatient = repo.save(entity);
        log.info("retrived data {}", retrivePatient);
        return Mapping.getPatientDTO(retrivePatient);
    }

    @Override
    public void addReports(List<ReportVo> report, Integer pid, Integer rid) throws ReportsNotAddedException, PatientNotFoundException {
//
        Optional<Patient> patient = repo.findById(pid);

        log.info("fetched patient record {}", patient);
        if (patient.isPresent()) {
            Patient patient1=patient.get();
            Optional<Report> reportOptinal = reportRepo.findById(rid);
            if (reportOptinal.isPresent()) {
                log.info("report present ");

                Report savedReport = reportOptinal.get();
                int age = savedReport.getPage();
                List<Report> reportsToBeSave = new ArrayList<>();
                List<CBCReport> cbcReportsLIST = new ArrayList<>();
                for (ReportVo vo : report) {
                    if (vo.getPage().equals(savedReport.getPage()) & vo.getReportName().equals(savedReport.getReportName())) {
                        List<CBCReportVO> reportVOList = vo.getList();
                        for (CBCReportVO vo1 : reportVOList) {
                             cbcReportsLIST.add(new CBCReport(vo1.getRedBloodCell(), vo1.getNeutrophil(), vo1.getEosinophil(), vo1.getBasophil(), vo1.getLymphocyte(), vo1.getMonocyte(),reportOptinal.get()));
                        }
                    } else {
                        reportsToBeSave.add(Mapping.getReports(vo,patient1));
                    }
                }
                if (cbcReportsLIST.isEmpty()){
                    log.info("adding to cbc reports ");
                    cbcRepos.saveAll(cbcReportsLIST);
                }
                else {
                    log.info("adding to reports ");

                    reportRepo.saveAll(reportsToBeSave);
                }

            }
            else {
                Iterable<Report> reportList = report.stream().map(reportVo -> new Report(reportVo.getPage(), reportVo.getInfectionName(), reportVo.getHaemoglobin(), reportVo.getPlatelets(), reportVo.getLiverFunctionTest(), reportVo.getInr(), reportVo.getReportName(), getCBCReport(reportVo.getList()), patient1)).collect(Collectors.toList());
                //Report report1 = new Report(report.getPage(), report.getInfectionName(), report.getHaemoglobin(), report.getPlatelets(), report.getLiverFunctionTest(), report.getInr(), report.getReportName(),getCBCReport(report.getList()),patient.get());
                List<Report> savedList = reportRepo.saveAll(reportList);
                System.out.println("reports are saved into db " + savedList.toString());
                //return Mapping.getReportResponseDTO(savedList);
            }
            } else {
            throw new PatientNotFoundException(1234, "generic exceptions during processing ");
        }
    }

    public static List<CBCReport> getCBCReport(List<CBCReportVO> list) {
        return list.stream().map(cbcReportVO -> new CBCReport(cbcReportVO.getRedBloodCell(), cbcReportVO.getNeutrophil(), cbcReportVO.getEosinophil(), cbcReportVO.getBasophil(), cbcReportVO.getLymphocyte(), cbcReportVO.getMonocyte())).collect(Collectors.toList());
    }


    @Override
    public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException {
        return null;
    }

    @Override
    public List<ReportResponseDTO> getReports(Integer reportID) throws ReportsNotAddedException {
        List<Report> reportList = reportRepo.findAll();
        if (!reportList.isEmpty()) {
            System.out.println("report detailes" + reportList);
            return Mapping.getReportResponseDTO(reportList);
        }
        throw new RuntimeException("there is no reports");
    }

//    @Override
//    public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException {
//        // TODO Auto-generated method stub
//        Optional<Patient> optional = repo.findById(pid);
//        if (optional.isPresent()) {
//            repo.deleteById(pid);
//            return Mapper.getPatientResponse(optional.get());
//        }
//        throw new PatientNotFoundException(config.patientNotFound, "patien not found");
//    }


}
