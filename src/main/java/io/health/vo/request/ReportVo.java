package io.health.vo.request;



import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReportVo {

    private Integer rid;
    private Integer page;
    private String infectionName;
    private String haemoglobin;
    private String platelets;
    private String liverFunctionTest;
    private Float inr;
    private String reportName;
    private List<CBCReportVO> list;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public List<CBCReportVO> getList() {
        return list;
    }

    public void setList(List<CBCReportVO> list) {
        this.list = list;
    }
}
