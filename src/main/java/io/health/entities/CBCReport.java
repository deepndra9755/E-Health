package io.health.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CBCReport {

	@Id
	@GeneratedValue
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
