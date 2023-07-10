package io.health.vo.request;

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
public class CBCReportRequest {
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
}
