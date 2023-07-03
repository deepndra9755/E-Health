package io.health.controller;

import java.time.LocalDate;

import io.health.dto.PatientRequestDto;
import io.health.vo.request.PatientRequestVo;

public class Mapper {
	
	public static PatientRequestDto getPatientRequestDto(PatientRequestVo requestVo) {
		return new PatientRequestDto(requestVo.getPid(),requestVo.getAadharNumber(),
				requestVo.getName(),requestVo.getLastName(),requestVo.getAddress(),
				requestVo.getMobile(),LocalDate.now());
	}
	

}
