package io.health.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.vo.request.CBCReportRequest;
import io.health.vo.request.PatientRequestVo;

public class Mapper {
	
	public static PatientRequestDto getPatientRequestDto(PatientRequestVo requestVo) {
		return new PatientRequestDto(requestVo.getPid(),requestVo.getAadharNumber(),
				requestVo.getName(),requestVo.getLastName(),requestVo.getAddress(),
				requestVo.getMobile(),LocalDate.now());
	}
	


	public static List<CBCReportDto> getCbcReportsDto(List<CBCReportRequest> list) {
		// TODO Auto-generated method stub
		return list.stream().map(mapper-> new CBCReportDto(
				mapper.getAge(), 
				mapper.getDate(), 
				mapper.getHaemoglobin(), 
				mapper.getRbcCount(),
				mapper.getPcv(),
				mapper.getMCV(),
				mapper.getMCH(),
				mapper.getMCHC(), 
				mapper.getRDW(),
				mapper.getTotalWBCCount(),
				mapper.getNeutrophils(), 
				mapper.getLymphocytes(),
				mapper.getEosinophils(),
				mapper.getMonocytes(), 
				mapper.getBasophils(),
				mapper.getPlateletCount())).collect(Collectors.toList());
				
	}
	
	

}
