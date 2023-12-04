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
public abstract class Report {

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
    @JoinColumn(name="PATIENT_ID")
    private Patient patient;

    public Report(Integer page, String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr, String reportName, Patient patient) {
        this.page = page;
        this.infectionName = infectionName;
        this.haemoglobin = haemoglobin;
        this.platelets = platelets;
        this.liverFunctionTest = liverFunctionTest;
        this.inr = inr;
        this.reportName = reportName;
        this.patient = patient;
    }
}

