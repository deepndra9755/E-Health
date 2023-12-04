package io.health.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class CBCReportDto extends ReportDTO {

	/**
	 * 
	 */
	private String redBloodCell;
	private String neutrophil;
	private String eosinophil;
	private String basophil;
	private String lymphocyte;
	private String monocyte;

	public CBCReportDto(Integer rid, Integer page, String infectionName, String haemoglobin, String platelets,
						String liverFunctionTest, Float inr, String reportName, LocalDate dt,
						String redBloodCell, String neutrophil, String eosinophil, String basophil,
						String lymphocyte, String monocyte) {
		super(rid, page, infectionName, haemoglobin, platelets, liverFunctionTest, inr, reportName, dt);
		this.redBloodCell = redBloodCell;
		this.neutrophil = neutrophil;
		this.eosinophil = eosinophil;
		this.basophil = basophil;
		this.lymphocyte = lymphocyte;
		this.monocyte = monocyte;
	}
}
