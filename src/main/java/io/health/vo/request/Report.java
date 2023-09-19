package io.health.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Report {
	
	private CBCReportRequest cbcReportRequest;
	private LunarReport lunarReportRequest;
	
}
