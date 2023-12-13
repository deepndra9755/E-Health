package io.health.service;

import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.dto.ReportResponseDTO;
import io.health.entities.Patient;
import io.health.entities.Report;
import io.health.exceptions.GeneralException;
import io.health.exceptions.PatientNotFoundException;
import io.health.exceptions.ReportsNotAddedException;
import io.health.vo.request.ReportVo;

import java.util.List;

public interface PatientService {
	
	//public void checkPatienExist(String pid);
	public PatientResponseDto addPatient(PatientRequestDto dto);
	
	public List<ReportResponseDTO> addReports(List<ReportVo> reports, Integer pid) throws ReportsNotAddedException;

	public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException;

	public Patient getPatient(Integer pid) throws ReportsNotAddedException;


}
