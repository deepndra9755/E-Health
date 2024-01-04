package io.health.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.dto.ReportResponseDTO;
import io.health.entities.Patient;
import io.health.entities.Report;
import io.health.exceptions.PatientNotFoundException;
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
    public ResponseEntity<PatientResponseDto> addPatient(@RequestBody PatientRequestDto request) throws AadharInvalidException, GeneralException, JsonProcessingException {
        log.info("request come to add patinet");
        PatientResponseDto patientResponse = patientService.addPatient(request);
        return new ResponseEntity<>(patientResponse, HttpStatus.OK);

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
        ReportResponseDTO report = patientService.getReports(rid);
        System.out.println("response :" + report);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }
//






}