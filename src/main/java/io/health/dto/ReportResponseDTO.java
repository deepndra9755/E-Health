package io.health.dto;

import io.health.entities.CBCReport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getInfectionName() {
        return infectionName;
    }

    public void setInfectionName(String infectionName) {
        this.infectionName = infectionName;
    }

    public String getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(String haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public String getPlatelets() {
        return platelets;
    }

    public void setPlatelets(String platelets) {
        this.platelets = platelets;
    }

    public String getLiverFunctionTest() {
        return liverFunctionTest;
    }

    public void setLiverFunctionTest(String liverFunctionTest) {
        this.liverFunctionTest = liverFunctionTest;
    }

    public Float getInr() {
        return inr;
    }

    public void setInr(Float inr) {
        this.inr = inr;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public List<CBCReportResponseDTO> getReports() {
        return reports;
    }

    public void setReports(List<CBCReportResponseDTO> reports) {
        this.reports = reports;
    }
}
