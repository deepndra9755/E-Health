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
public class CBCReportRequest extends Report {
	private String haemoglobin;
	private String rbcCount;
	private String pcv;
	private String mcv;
	private String mch;
	private String mchc;
	private String rdw;
	private String totalWBCCount;
	private String neutrophils;
	private String lymphocytes;
	private String eosinophils;
	private String monocytes;
	private String basophils;
	private String plateletCount;
}
