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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

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
    public List<Report> addReports(ReportVo reportVo, Integer pid, Integer rid) throws ReportsNotAddedException, PatientNotFoundException {
//
        Optional<Patient> patient = repo.findById(pid);
        log.info("fetched patient record {}", patient);
        if (patient.isPresent()) {
            Patient patient1 = patient.get();
            List<Report> reportList = reportRepo.findByPatientPid(patient1.getPid());

            for (Report reportRetrive : reportList) {
                log.info("reportName:  {} reportId : {} page: {} infectionName: {} platelets: {} pid: {}", reportRetrive.getReportName(),
                        reportRetrive.getReportId(),
                        reportRetrive.getPage(),
                        reportRetrive.getInfectionName(),
                        reportRetrive.getPlatelets(),
                        reportRetrive.getPatient().getPid()
                );
                if (reportRetrive.getReportName().equals(reportVo.getReportName()) & reportRetrive.getPage().equals(reportVo.getPage())) {
                    List<CBCReport> cbcReport = Mapping.getCBCReport(reportVo.getList(), reportRetrive);
                    cbcRepos.saveAll(cbcReport);
                    log.info("saving cbc reports");
                    return findByIdReport(pid);
                }
            }
            reportRepo.save(Mapping.getReports(reportVo, patient1));
            log.info("saving reports");
            return findByIdReport(pid);
        }
        throw new PatientNotFoundException(123, "");

    }

    public List<Report> findByIdReport(Integer id) {
        return reportRepo.findByPatientPid(id);
    }


    @Override
    public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException {
        return null;
    }

    @Override
    public ReportResponseDTO getReports(Integer reportID) throws ReportsNotAddedException {
        Optional<Report> reportList = reportRepo.findById(reportID);
        if (reportList.isPresent()) {
            System.out.println("report detailes" + reportList);
            return Mapping.getReportResponseDTO(reportList.get());
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
