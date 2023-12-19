package io.health.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class CBCReportResponseDTO {

    private Integer cid;
    private String redBloodCell;
    private String neutrophil;
    private String eosinophil;
    private String basophil;
    private String lymphocyte;
    private String monocyte;


    public CBCReportResponseDTO(Integer cid, String redBloodCell, String neutrophil, String eosinophil, String basophil, String lymphocyte, String monocyte) {
        this.cid = cid;
        this.redBloodCell = redBloodCell;
        this.neutrophil = neutrophil;
        this.eosinophil = eosinophil;
        this.basophil = basophil;
        this.lymphocyte = lymphocyte;
        this.monocyte = monocyte;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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
