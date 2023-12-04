package io.health.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class ReportDTO {

    private Integer rid;
    private Integer page;
    private String infectionName;
    private String haemoglobin;
    private String platelets;
    private String liverFunctionTest;
    private Float inr;
    private String reportName;
    private LocalDate dt;


    public ReportDTO(Integer rid, Integer page, String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr, String reportName, LocalDate dt) {
        this.rid = rid;
        this.page = page;
        this.infectionName = infectionName;
        this.haemoglobin = haemoglobin;
        this.platelets = platelets;
        this.liverFunctionTest = liverFunctionTest;
        this.inr = inr;
        this.reportName = reportName;
        this.dt = dt;
    }
}
