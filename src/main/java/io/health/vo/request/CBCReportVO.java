package io.health.vo.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonTypeName("cbcReportVO")
public class CBCReportVO extends ReportVo {

    @JsonProperty("redBloodCell")
    private String redBloodCell;

    @JsonProperty("neutrophil")
    private String neutrophil;

    @JsonProperty("eosinophil")
    private String eosinophil;

    @JsonProperty("basophil")
    private String basophil;

    @JsonProperty("lymphocyte")
    private String lymphocyte;

    @JsonProperty("monocyte")
    private String monocyte;

    // Default constructor
    public CBCReportVO() {
        // Call the default constructor of the superclass if necessary
        super();
    }

    // Constructor for JSON deserialization using Jackson
    @JsonCreator
    public CBCReportVO(
            @JsonProperty("page") Integer page,
            @JsonProperty("infectionName") String infectionName,
            @JsonProperty("haemoglobin") String haemoglobin,
            @JsonProperty("platelets") String platelets,
            @JsonProperty("liverFunctionTest") String liverFunctionTest,
            @JsonProperty("inr") Float inr,
            @JsonProperty("reportName") String reportName,
            @JsonProperty("redBloodCell") String redBloodCell,
            @JsonProperty("neutrophil") String neutrophil,
            @JsonProperty("eosinophil") String eosinophil,
            @JsonProperty("basophil") String basophil,
            @JsonProperty("lymphocyte") String lymphocyte,
            @JsonProperty("monocyte") String monocyte) {

        super(page, infectionName, haemoglobin, platelets, liverFunctionTest, inr, reportName);

        this.redBloodCell = redBloodCell;
        this.neutrophil = neutrophil;
        this.eosinophil = eosinophil;
        this.basophil = basophil;
        this.lymphocyte = lymphocyte;
        this.monocyte = monocyte;
    }

    // Getters and setters
}
