package io.health.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.entities.CBCReport;
import io.health.entities.Patient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mapper {
	
	public static final Patient getPatient(PatientRequestDto requestDto) {
	return new Patient(requestDto.getAadharNumber(), requestDto.getName(), requestDto.getLastName(), requestDto.getAddress(), requestDto.getMobile(), requestDto.getDate());
	
			}
	
public static final PatientResponseDto getPatientResponse(Patient patient) {
	
return new PatientResponseDto(patient.getPid(), patient.getAadharNumber(), patient.getName(), patient.getLastName(), patient.getAddress(), patient.getMobile(), patient.getDate(),
		getPatientReport(patient.getReports())
		);	
}

public static final List<CBCReportDto> getPatientReport(List<CBCReport> listReport) {
    log.info("inside service mapper");
	if (listReport==null) {
	    log.info("if null");
		return Collections.emptyList();
	    
	}
    log.info("if not null");

	return listReport.stream().map(list -> new CBCReportDto(list.getCbcReportId(), list.getAge(), list.getHaemoglobin(), list.getRbcCount(), list.getPcv(), list.getMCV(), list.getMCH(), list.getMCHC(), list.getRDW(), list.getTotalWBCCount(), list.getNeutrophils(), list.getLymphocytes(), list.getEosinophils(), list.getMonocytes(), list.getBasophils(), 
		list.getPlateletCount())).collect(Collectors.toList());	
}

}
