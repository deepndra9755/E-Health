package io.health.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.health.config.StatusCodeConfig;
import io.health.dto.CBCReportDto;
import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.entities.CBCReport;
import io.health.entities.Patient;
import io.health.exceptions.GeneralException;
import io.health.exceptions.PatientNotFoundException;
import io.health.exceptions.ReportsNotAddedException;
import io.health.repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {
	
	@Autowired(required = true)
	private PatientRepo repo;
	
	@Autowired
	private StatusCodeConfig config;

	@Override
	public PatientResponseDto addPatient(PatientRequestDto dto) {
		// TODO Auto-generated method stub
				Patient entity=Mapper.getPatient(dto);
				Patient retrivePatient=repo.save(entity);
				log.info("retrived data {}",retrivePatient);

		       return Mapper.getPatientResponse(retrivePatient);
	}

	@Override
	public PatientResponseDto addReports(List<CBCReportDto> reports, Integer pid) throws ReportsNotAddedException {
		// TODO Auto-generated method stub
		Optional<Patient> patient=repo.findById(pid);
		log.info("fetched patient record {}",patient);
		if(patient.isPresent())
		{
			Patient savedPatient=patient.get();
		    List<CBCReport> retriveReports=savedPatient.getReports();
		   
		    	retriveReports.addAll(Mapper.getReports(reports));
		        savedPatient.setReports(retriveReports);
		        log.info("before save {}",savedPatient);
		       return Mapper.getPatientResponse(repo.save(savedPatient));

		}
		throw new ReportsNotAddedException(config.reportsNotadded,"generic exceptions during processing ");
		
			}

	@Override
	public PatientResponseDto deletePatient(Integer pid) throws GeneralException, PatientNotFoundException {
		// TODO Auto-generated method stub
		Optional<Patient> optional=repo.findById(pid);
		if(optional.isPresent()) {
			repo.deleteById(pid);
			return Mapper.getPatientResponse(optional.get());
		}
		throw new PatientNotFoundException(config.patientNotFound, "patien not found");
	}
	




}
