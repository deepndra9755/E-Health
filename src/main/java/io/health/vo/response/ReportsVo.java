package io.health.vo.response;

import java.time.LocalDate;
import java.util.List;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ReportsVo {

	
	private Integer rid;
	private Integer page;
	private String infectionName;
	private String haemoglobin;
	private String platelets;
	private String liverFunctionTest;
	private Float inr;
	@Nullable
	private LocalDate dt;

	public ReportsVo(Integer rid2, Integer pAge2, Integer pAge3, String infectionName2, String haemoglobin2,
			String platelets2, String liverFunctionTest2, Float inr2, LocalDate dt2) {
		// TODO Auto-generated constructor stub
		this.rid = rid2;
		this.page = pAge2;
		this.infectionName = infectionName2;
		this.haemoglobin = haemoglobin2;
		this.platelets = platelets2;
		this.liverFunctionTest = liverFunctionTest2;
		this.inr = inr2;
		this.dt = dt2;
	}
	
	
}
