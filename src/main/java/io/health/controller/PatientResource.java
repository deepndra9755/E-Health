package io.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.exceptions.AadharInvalidException;
import io.health.exceptions.GeneralException;
import io.health.exceptions.PatientNotFoundException;
import io.health.exceptions.ReportsNotAddedException;
import io.health.response.ResponseBuilder;
import io.health.service.PatientService;
import io.health.utils.Utility;
import io.health.vo.request.CBCReportRequest;
import io.health.vo.request.PatientRequestVo;
import io.health.vo.request.Report;
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
	
	@Autowired
	private Utility utility;
	
@PostMapping("/Patient")
public ResponseVo addPatient(@RequestBody PatientRequestVo request) throws AadharInvalidException, GeneralException, JsonProcessingException {
  // checkPatientExist(request.getAadharNumber());
	log.info("request come to add patinet");
	utility.isValidAadharValidation(request.getAadharNumber());
   PatientRequestDto requestDto= Mapper.getPatientRequestDto(request);
   PatientResponseDto patientResponse=patientService.addPatient(requestDto);
   return response.buildFinalResponse(patientResponse, "Success", 3000);
  
}

@PostMapping("/Patient/{pid}")
public String addReports(@RequestBody Report report ,@PathVariable("pid") Integer pid) throws AadharInvalidException, GeneralException, ReportsNotAddedException, JsonProcessingException {
  // checkPatientExist(request.getAadhasrNumber());
	log.info("request come to add report");
	log.info("report having full impl {}",report);

   return new ObjectMapper().writeValueAsString(report);
   
}

//@DeleteMapping("/Patient/{pid}")
//public ResponseVo addReports(@PathVariable("pid") Integer pid) throws AadharInvalidException, GeneralException, PatientNotFoundException {
//  // checkPatientExist(request.getAadharNumber());
//	log.info("request come to delete patient & reports");
//   PatientResponseDto patientResponse=patientService.deletePatient(pid);
//   log.info("confirmation msg  :: {}",response.buildFinalResponse(patientResponse, "Success", 3000));
//   return response.buildFinalResponse(patientResponse, "Success", 3000);
//   
//}
	 

}