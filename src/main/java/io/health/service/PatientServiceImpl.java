package io.health.service;

import java.util.Optional;

import io.health.entities.Report;
import io.health.repository.ReportRespo;
import io.health.service.mapper.Mapper;
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

    @Autowired
    private StatusCodeConfig config;

    @Override
    public Patient addPatient(PatientRequestDto dto) {
        // TODO Auto-generated method stub
        Patient entity = Mapper.getPatient(dto);
        Patient retrivePatient = repo.save(entity);
        log.info("retrived data {}", retrivePatient);
        //return Mapper.getPatientResponse(retrivePatient);
        return retrivePatient;
    }

    @Override
    public Report addReports(ReportVo report, Integer pid) throws ReportsNotAddedException {
        // TODO Auto-generated method stub
        Optional<Patient> patient = repo.findById(pid);
        log.info("fetched patient record {}", patient);
        if (patient.isPresent()) {
            if (report instanceof ReportVo) {
                CBCReportVO cbcReportVO = (CBCReportVO) report;
                CBCReport cbcReport = new CBCReport(
                        report.getPage(),
                        report.getInfectionName(),
                        report.getHaemoglobin(),
                        report.getPlatelets(),
                        report.getLiverFunctionTest(),
                        report.getInr(),
                        report.getReportName(),
                        cbcReportVO.getRedBloodCell(),  // Set values specific to CBCReport
                        cbcReportVO.getNeutrophil(),
                        cbcReportVO.getEosinophil(),
                        cbcReportVO.getBasophil(),
                        cbcReportVO.getLymphocyte(),
                        cbcReportVO.getMonocyte(),
                        patient.get()

                );

             return reportRepo.save(cbcReport)  ;

            }
        }

        throw new ReportsNotAddedException(config.reportsNotadded, "generic exceptions during processing ");

    }

    @Override
    public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException {
        return null;
    }

    @Override
    public Patient getPatient(Integer pid) throws ReportsNotAddedException {
      Optional<Patient> patient=repo.findById(pid);
       if (patient.isPresent()){
       Optional<Report> reportOptional=reportRepo.findById(pid);
           System.out.println("report detailes"+reportOptional.get());

       }

return null;
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
