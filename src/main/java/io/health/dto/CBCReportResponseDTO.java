package io.health.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
}
