package io.health.vo.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class CBCReportVO  {

    private String redBloodCell;

    private String neutrophil;

    private String eosinophil;

    private String basophil;

    private String lymphocyte;

    private String monocyte;

    public String getRedBloodCell() {
        return redBloodCell;
    }

    public void setRedBloodCell(String redBloodCell) {
        this.redBloodCell = redBloodCell;
    }

    public String getNeutrophil() {
        return neutrophil;
    }

    public void setNeutrophil(String neutrophil) {
        this.neutrophil = neutrophil;
    }

    public String getEosinophil() {
        return eosinophil;
    }

    public void setEosinophil(String eosinophil) {
        this.eosinophil = eosinophil;
    }

    public String getBasophil() {
        return basophil;
    }

    public void setBasophil(String basophil) {
        this.basophil = basophil;
    }

    public String getLymphocyte() {
        return lymphocyte;
    }

    public void setLymphocyte(String lymphocyte) {
        this.lymphocyte = lymphocyte;
    }

    public String getMonocyte() {
        return monocyte;
    }

    public void setMonocyte(String monocyte) {
        this.monocyte = monocyte;
    }
}
