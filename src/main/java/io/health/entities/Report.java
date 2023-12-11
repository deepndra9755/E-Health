package io.health.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@ToString
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

    @OneToOne
    @JoinColumn(name="PATIENT_ID")
    private Patient patient;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CBCReport> reports;


    public Report(Integer page, String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr, String reportName, List<CBCReport> reports) {
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

