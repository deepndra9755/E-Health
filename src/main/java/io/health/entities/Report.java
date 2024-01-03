package io.health.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Entity
//@ToString
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    private Integer page;
    private String infectionName;
    private String haemoglobin;
    private String platelets;
    private String liverFunctionTest;
    private Float inr;
    private String reportName;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "report_id")
    private List<CBCReport> reports;


    public Report(Integer page, String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr, String reportName, List<CBCReport> reports,Patient patient) {
        this.page = page;
        this.infectionName = infectionName;
        this.haemoglobin = haemoglobin;
        this.platelets = platelets;
        this.liverFunctionTest = liverFunctionTest;
        this.inr = inr;
        this.reportName = reportName;
        this.reports = reports;
        this.patient=patient;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<CBCReport> getReports() {
        return reports;
    }

    public void setReports(List<CBCReport> reports) {
        this.reports = reports;
    }
}

