package io.health.vo.request;

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
public class LunarReport extends Report{
	private String haemoglobin;
	private String sdsds;
	private String pcv;
	private String mcv;
	private String mch;
	private String mchc;
	private String rdw;
	private String dddss;
	private String neutrophils;
	private String lymphocytes;
	private String eosinophils;
	private String monocytes;
	private String basophils;
	private String plateletCount;
}
