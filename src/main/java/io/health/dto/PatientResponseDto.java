package io.health.dto;

import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class PatientResponseDto  {
	private Integer pid;
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	private LocalDate date;


	public PatientResponseDto(Integer pid, String aadharNumber, String name, String lastName, String address, Long mobile, LocalDate date) {
		this.pid = pid;
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.date = date;
	}
}
