package io.health.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CBCReportDto implements Serializable {

	private Integer cbcReportId;
	private Integer age;
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
	
}
