package io.health.service;

import java.util.List;

import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.exceptions.GeneralException;

public interface PatientService {
	
	//public void checkPatienExist(String pid);
	public PatientResponseDto addPatient(PatientRequestDto dto);
	
	public PatientResponseDto addReports(List<CBCReportDto> reports,Integer pid) throws GeneralException;


}
