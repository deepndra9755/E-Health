package io.health.vo.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class ReportRequestedVo {
	private Integer page;
	private String infectionName;
	private String haemoglobin;
	private String platelets;
	private String liverFunctionTest;
	private Float inr;
	private LocalDate date;


}
