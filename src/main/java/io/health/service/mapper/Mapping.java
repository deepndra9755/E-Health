package io.health.service.mapper;

import io.health.dto.CBCReportResponseDTO;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.dto.ReportResponseDTO;
import io.health.entities.CBCReport;
import io.health.entities.Patient;
import io.health.entities.Report;
import io.health.vo.request.CBCReportVO;
import io.health.vo.request.ReportVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static final Patient getPatient(PatientRequestDto patientRequestDto) {
        return new Patient(patientRequestDto.getAadharNumber(), patientRequestDto.getName(), patientRequestDto.getLastName(), patientRequestDto.getAddress(), patientRequestDto.getMobile(), patientRequestDto.getDate());
    }

    public static final PatientResponseDto getPatientDTO(Patient patient) {
        return new PatientResponseDto(patient.getPid(), patient.getAadharNumber(), patient.getName(), patient.getLastName(), patient.getAddress(), patient.getMobile(), patient.getDate());
    }

    public static final List<CBCReportResponseDTO> getCBCReportDTO(List<CBCReport> reports) {
        return reports.stream()
                .map(report -> new CBCReportResponseDTO(
                        report.getCid(),
                        report.getRedBloodCell(),
                        report.getNeutrophil(),
                        report.getEosinophil(),
                        report.getBasophil(),
                        report.getLymphocyte(),
                        report.getMonocyte()
                ))
                .collect(Collectors.toList());
    }

    public static final List<CBCReport> getCBCReport(List<CBCReportVO> reports) {
        return reports.stream()
                .map(report -> new CBCReport(
                        report.getRedBloodCell(),
                        report.getNeutrophil(),
                        report.getEosinophil(),
                        report.getBasophil(),
                        report.getLymphocyte(),
                        report.getMonocyte()
                ))
                .collect(Collectors.toList());
    }

    public static final List<CBCReport> getCBCReport(List<CBCReportVO> reports,Report report1) {
        return reports.stream()
                .map(report -> new CBCReport(
                        report.getRedBloodCell(),
                        report.getNeutrophil(),
                        report.getEosinophil(),
                        report.getBasophil(),
                        report.getLymphocyte(),
                        report.getMonocyte(),report1
                ))
                .collect(Collectors.toList());
    }


    public static final List<ReportResponseDTO> getReportResponseDTO(List<Report> reports) {
        List<ReportResponseDTO> reportResponseDTOList = new ArrayList<ReportResponseDTO>();

        for (Report report : reports) {
            ReportResponseDTO reportResponseDTO = new ReportResponseDTO(
                    report.getReportId(),
                    report.getPage(),
                    report.getInfectionName(),
                    report.getHaemoglobin(),
                    report.getPlatelets(),
                    report.getLiverFunctionTest(),
                    report.getInr(),
                    report.getReportName(),
                    getCBCReportDTO(report.getReports())
            );

            reportResponseDTOList.add(reportResponseDTO);
        }

        return reportResponseDTOList;
    }

    //	public CBCReport(String redBloodCell, String neutrophil, String eosinophil, String basophil, String lymphocyte, String monocyte) {
    public static final CBCReport getCBCReport(CBCReportVO cbcReportVO){
       return new CBCReport(cbcReportVO.getRedBloodCell(),cbcReportVO.getNeutrophil(),cbcReportVO.getEosinophil(),cbcReportVO.getBasophil(),cbcReportVO.getLymphocyte(),cbcReportVO.getMonocyte());
    }

    public static final Report getReports(ReportVo reportVo,Patient patient1){
      return new Report(reportVo.getPage(),reportVo.getInfectionName(),reportVo.getHaemoglobin(),reportVo.getPlatelets(),reportVo.getLiverFunctionTest(),reportVo.getInr(),reportVo.getReportName(),getCBCReport(reportVo.getList()),patient1);
    }

    public static final ReportResponseDTO getReportResponseDTO(Report report) {

        return new ReportResponseDTO(
                report.getReportId(),
                report.getPage(),
                report.getInfectionName(),
                report.getHaemoglobin(),
                report.getPlatelets(),
                report.getLiverFunctionTest(),
                report.getInr(),
                report.getReportName(),
                getCBCReportDTO(report.getReports())
        );


    }
    }
