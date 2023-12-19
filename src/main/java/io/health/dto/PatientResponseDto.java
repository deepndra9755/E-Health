package io.health.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class PatientResponseDto {
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
