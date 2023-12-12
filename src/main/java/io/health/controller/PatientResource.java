package io.health.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.entities.Patient;
import io.health.entities.Report;
import io.health.vo.request.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.health.exceptions.AadharInvalidException;
import io.health.exceptions.GeneralException;
import io.health.exceptions.ReportsNotAddedException;
import io.health.response.ResponseBuilder;
import io.health.service.PatientService;
import io.health.utils.Utility;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
public ResponseEntity<Patient> addPatient(@RequestBody PatientRequestDto request) throws AadharInvalidException, GeneralException, JsonProcessingException {
  // checkPatientExist(request.getAadharNumber());
	log.info("request come to add patinet");
	//utility.isValidAadharValidation(request.getAadharNumber());
   //PatientRequestDto requestDto= Mapper.getPatientRequestDto(request);
	Patient patientResponse=patientService.addPatient(request);
   return new ResponseEntity<Patient>(patientResponse,HttpStatus.OK);

}

@PostMapping("/report/{pid}")
public ResponseEntity<Report> addReports(@RequestBody ReportVo reports,@PathVariable Integer pid) throws AadharInvalidException, GeneralException, ReportsNotAddedException {
   //checkPatientExist(request.getAadhasrNumber());
	patientService.addReports(reports, pid);
  return  new ResponseEntity<>(null, HttpStatus.OK);
}

	@GetMapping("/report/{pid}")
	public ResponseEntity<Patient> getReports(
			@PathVariable Integer pid) throws AadharInvalidException, GeneralException, ReportsNotAddedException {
		//checkPatientExist(request.getAadhasrNumber());
		Patient patientResponse=patientService.getPatient(pid);
		System.out.println("response :"+patientResponse);
//   log.info("after saved :: {}",response.buildFinalResponse(patientResponse, "Success", 3000));
//   return response.buildFinalResponse(patientResponse, "Success", 3000);
		return  new ResponseEntity<Patient>(patientResponse, HttpStatus.OK);
	}

	@GetMapping("/patient/{pid}")
	public ResponseEntity<Patient> getPatient(
			@PathVariable Integer pid) throws AadharInvalidException, GeneralException, ReportsNotAddedException {
		//checkPatientExist(request.getAadhasrNumber());
		Patient patientResponse=patientService.getPatient(pid);
		System.out.println("response :"+patientResponse);
//   log.info("after saved :: {}",response.buildFinalResponse(patientResponse, "Success", 3000));
//   return response.buildFinalResponse(patientResponse, "Success", 3000);
		return  new ResponseEntity<Patient>(patientResponse, HttpStatus.OK);
	}


//@DeleteMapping("/Patient/{pid}")
//public ResponseVo deleteReports(@PathVariable("pid") Integer pid) throws AadharInvalidException, GeneralException, PatientNotFoundException {
//  // checkPatientExist(request.getAadharNumber());
//	log.info("request come to delete patient & reports");
//   PatientResponseDto patientResponse=patientService.deletePatient(pid);
//   log.info("confirmation msg  :: {}",response.buildFinalResponse(patientResponse, "Success", 3000));
//   return response.buildFinalResponse(patientResponse, "Success", 3000);
//
//}
	 

}