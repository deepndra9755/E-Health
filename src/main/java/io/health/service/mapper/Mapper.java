package io.health.service.mapper;

import io.health.dto.CBCReportResponseDTO;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.dto.ReportResponseDTO;
import io.health.entities.CBCReport;
import io.health.entities.Patient;
import io.health.entities.Report;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static final Patient getPatient(PatientRequestDto patientRequestDto){
      return new Patient(patientRequestDto.getAadharNumber(),patientRequestDto.getName(),patientRequestDto.getLastName(),patientRequestDto.getAddress(),patientRequestDto.getMobile(),patientRequestDto.getDate());
    }

    public static final PatientResponseDto getPatientDTO(Patient patient){
        return new PatientResponseDto(patient.getPid(),patient.getAadharNumber(),patient.getName(),patient.getLastName(),patient.getAddress(),patient.getMobile(),patient.getDate());
    }

    public static final List<CBCReportResponseDTO> getCBCReportDTO(List<CBCReport> report1){

        return  report1.stream().map(report -> new CBCReportResponseDTO(report.getCid(),report.getRedBloodCell(),report.getNeutrophil(),report.getEosinophil(),report.getBasophil(),report.getLymphocyte(),report.getMonocyte())).collect(Collectors.toList());
       // return new CBCReportResponseDTO(report.getCid(),report.getRedBloodCell(),report.getNeutrophil(),report.getEosinophil(),report.getBasophil(),report.getLymphocyte(),report.getMonocyte());
    }

    public static final ReportResponseDTO getReportResponseDTO(Report report){
        return new ReportResponseDTO(report.getReportId(),report.getPage(),report.getInfectionName(),report.getHaemoglobin(),report.getPlatelets(),report.getLiverFunctionTest(),report.getInr(),report.getReportName(),getCBCReportDTO(report.getReports()));
    }
}
