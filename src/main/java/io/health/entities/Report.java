package io.health.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
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
        this.patient=patient;
        this.reports = reports;
    }
}

