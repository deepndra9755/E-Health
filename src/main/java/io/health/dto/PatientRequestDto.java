package io.health.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class PatientRequestDto implements Serializable {
	
	@Nullable
	private Integer pid;
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	private final LocalDate date;
	
	

}
