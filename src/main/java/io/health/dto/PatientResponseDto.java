package io.health.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Nullable
	private Integer pid;
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	private  LocalDate date;
	
	private List<CBCReportDto> list;
}
