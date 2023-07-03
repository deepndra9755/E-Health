package io.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.service.PatientService;
import io.health.utills.ResponseBuilder;
import io.health.vo.request.PatientRequestVo;
import io.health.vo.response.PatientVo;
import io.health.vo.response.ResponseVo;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PatientResource {
	
	
	@Autowired(required = true)
	private PatientService patientService;
	
	@Autowired(required = true)
	private ResponseBuilder response;
	
@PostMapping("/Patient")
public ResponseVo addPatient(@RequestBody PatientRequestVo request) {
  // checkPatientExist(request.getAadharNumber());
	log.info("request come to add patinet");
   PatientRequestDto requestDto= Mapper.getPatientRequestDto(request);
   PatientResponseDto patientResponse=patientService.addPatient(requestDto);

   return response.buildFinalResponse(patientResponse, "Success", 3000);
  
}


}