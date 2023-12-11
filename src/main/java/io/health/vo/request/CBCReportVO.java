package io.health.vo.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CBCReportVO  {

    private String redBloodCell;

    private String neutrophil;

    private String eosinophil;

    private String basophil;

    private String lymphocyte;

    private String monocyte;


}
