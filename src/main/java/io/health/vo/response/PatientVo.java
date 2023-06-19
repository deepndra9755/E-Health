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
public class PatientVo {

	@Nullable
	private Integer pid;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	@Nullable
	private LocalDate date;
	private List<ReportsVo> reports;

}
