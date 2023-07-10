package io.health.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.exceptions.AadharInvalidException;
import io.health.exceptions.GeneralException;
import io.health.service.PatientService;
import io.health.utills.ResponseBuilder;
import io.health.vo.request.CBCReportRequest;
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
public ResponseVo addPatient(@RequestBody PatientRequestVo request) throws AadharInvalidException, GeneralException, JsonProcessingException {
  // checkPatientExist(request.getAadharNumber());
	log.info("request come to add patinet");
	isValidAadharValidation(request.getAadharNumber());
   PatientRequestDto requestDto= Mapper.getPatientRequestDto(request);
   PatientResponseDto patientResponse=patientService.addPatient(requestDto);
  
   return response.buildFinalResponse(patientResponse, "Success", 3000);
  
}

@PostMapping("/Patient/{pid}")
public ResponseVo addReports(@RequestBody List<CBCReportRequest> list,@PathVariable("pid") Integer pid) throws AadharInvalidException, GeneralException {
  // checkPatientExist(request.getAadharNumber());
	log.info("request come to add report");
   List<CBCReportDto> reportList= Mapper.getCbcReportsDto(list);
   PatientResponseDto patientResponse=patientService.addReports(reportList, pid);
   log.info("after saved :: {}",response.buildFinalResponse(patientResponse, "Success", 3000));
   return response.buildFinalResponse(patientResponse, "Success", 3000);
   
   
  
}


public void isValidAadharValidation(String str) throws AadharInvalidException, GeneralException {

	        // Regex to check valid Aadhaar number.
	        String regex
	            = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
	 
	        // Compile the ReGex
	        Pattern p = Pattern.compile(regex);
	 
	        // If the string is empty
	        // return false
	        if (str == null) {
	            throw new GeneralException("aadhar card is mandtory", "8448");
	        }
	 
	        // Pattern class contains matcher() method
	        // to find matching between given string
	        // and regular expression.
	        Matcher m = p.matcher(str);
	
	        // Return if the string
	        // matched the ReGex
	         if(m.matches()) {
	         return; 
	         }
	        
	        throw new AadharInvalidException("invalid aadhar number", "8448");

	    }
	 

}