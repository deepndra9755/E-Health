package io.health.dto;

import io.health.entities.CBCReport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ReportResponseDTO {

    private Integer reportId;
    private Integer page;
    private String infectionName;
    private String haemoglobin;
    private String platelets;
    private String liverFunctionTest;
    private Float inr;
    private String reportName;
    private List<CBCReportResponseDTO> reports;

    public ReportResponseDTO(Integer reportId, Integer page, String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr, String reportName, List<CBCReportResponseDTO> reports) {
        this.reportId = reportId;
        this.page = page;
        this.infectionName = infectionName;
        this.haemoglobin = haemoglobin;
        this.platelets = platelets;
        this.liverFunctionTest = liverFunctionTest;
        this.inr = inr;
        this.reportName = reportName;
        this.reports = reports;
    }
}
