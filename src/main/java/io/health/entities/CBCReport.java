package io.health.entities;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString
@PrimaryKeyJoinColumn(name = "repo_id",referencedColumnName ="reportId")
public class CBCReport extends Report {

	private String redBloodCell;
	private String neutrophil;
	private String eosinophil;
	private String basophil;
	private String lymphocyte;
	private String monocyte;



	public CBCReport(Integer page, String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr, String reportName,String redBloodCell, String neutrophil, String eosinophil, String basophil, String lymphocyte, String monocyte,Patient patient) {
		super(page, infectionName, haemoglobin, platelets, liverFunctionTest, inr, reportName,patient);
		this.redBloodCell = redBloodCell;
		this.neutrophil = neutrophil;
		this.eosinophil = eosinophil;
		this.basophil = basophil;
		this.lymphocyte = lymphocyte;
		this.monocyte = monocyte;
	}
}
