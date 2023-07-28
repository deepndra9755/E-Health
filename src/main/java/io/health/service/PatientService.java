package io.health.service;

import java.util.List;

import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.exceptions.GeneralException;
import io.health.exceptions.PatientNotFoundException;

public interface PatientService {
	
	//public void checkPatienExist(String pid);
	public PatientResponseDto addPatient(PatientRequestDto dto);
	
	public PatientResponseDto addReports(List<CBCReportDto> reports,Integer pid) throws GeneralException;

	public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException;

	
}
