package io.health.service;

import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;

public interface PatientService {
	
	//public void checkPatienExist(String pid);
	public PatientResponseDto addPatient(PatientRequestDto dto);

}
