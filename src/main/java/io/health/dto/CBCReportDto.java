package io.health.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CBCReportDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cbcReportId;
	private Integer age;
	private LocalDate date;
	private String haemoglobin;
	private String rbcCount;
	private String pcv;
	private String mCV;
	private String mCH;
	private String mCHC;
	private String rDW;
	private String totalWBCCount;
	private String neutrophils;
	private String lymphocytes;
	private String eosinophils;
	private String monocytes;
	private String basophils;
	private String plateletCount;
	
	public CBCReportDto(Integer age, LocalDate date, String haemoglobin, String rbcCount, String pcv, String mCV,
			String mCH, String mCHC, String rDW, String totalWBCCount, String neutrophils, String lymphocytes,
			String eosinophils, String monocytes, String basophils, String plateletCount) {
		super();
		this.age = age;
		this.date = date;
		this.haemoglobin = haemoglobin;
		this.rbcCount = rbcCount;
		this.pcv = pcv;
		this.mCV = mCV;
		this.mCH = mCH;
		this.mCHC = mCHC;
		this.rDW = rDW;
		this.totalWBCCount = totalWBCCount;
		this.neutrophils = neutrophils;
		this.lymphocytes = lymphocytes;
		this.eosinophils = eosinophils;
		this.monocytes = monocytes;
		this.basophils = basophils;
		this.plateletCount = plateletCount;
	}
	
	
	
	
}
