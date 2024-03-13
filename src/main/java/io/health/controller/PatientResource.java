package io.health.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.dto.ReportResponseDTO;
import io.health.entities.Report;
import io.health.exceptions.PatientNotFoundException;
import io.health.vo.request.ReportVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v1")
public class PatientResource {

	
	private static final Logger log=LoggerFactory.getLogger(PatientResource.class);

    @Autowired(required = true)
    private PatientService patientService;

    @Autowired(required = true)
    private ResponseBuilder response;

    @Autowired
    private Utility utility;

    @PostMapping("/Patient")
    public ResponseEntity<PatientResponseDto> addPatient(@RequestBody PatientRequestDto request) throws AadharInvalidException, GeneralException, JsonProcessingException {
        checkAadharNumberIsValid(request.getAadharNumber());
        log.info("request come to add patinet");
        PatientResponseDto patientResponse = patientService.addPatient(request);
        return new ResponseEntity<>(patientResponse, HttpStatus.OK);

    }

    private boolean checkAadharNumberIsValid(String aadharNumber) {
            Pattern pattern = Pattern.compile("^[0-9]{12}$");
            Matcher matcher = pattern.matcher(aadharNumber);

        if (matcher.matches()) {
            return true;
        } else {
            throw new AadharInvalidException(202,"Invalid Aadhar number format");
        }

    }

    //
    @PostMapping("/patient/{pid}")
    public ResponseEntity<List<Report>> addReports(@RequestBody ReportVo reports, @PathVariable Integer pid, @PathVariable Integer rid) throws AadharInvalidException, GeneralException, ReportsNotAddedException, PatientNotFoundException {
        //checkPatientExist(request.getAadhasrNumber());
        List<Report> reportList = patientService.addReports(reports, pid, rid);
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }

    //
    @GetMapping("/report/{rid}")
    public ResponseEntity<ReportResponseDTO> getReports(
            @PathVariable Integer rid) throws AadharInvalidException, GeneralException, ReportsNotAddedException {
        ReportResponseDTO retiveReport = patientService.getReports(rid);
      log.info("response : {}",  retiveReport);
        return new ResponseEntity<>(retiveReport, HttpStatus.OK);
    }
//
    
    @DeleteMapping("report/{rid}")
    public ResponseEntity<Report> deleteReports(@PathVariable Integer rid) throws GeneralException, PatientNotFoundException {
        Report report=patientService.deleteReports(rid);
        return new ResponseEntity<>(report,HttpStatus.OK);
     }






}