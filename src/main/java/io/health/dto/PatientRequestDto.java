package io.health.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Setter
public class PatientRequestDto {
	
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	private  LocalDate date;

	public String getAadharNumber() {
		return aadharNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public Long getMobile() {
		return mobile;
	}

	public LocalDate getDate() {
		return date;
	}
}
