package io.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.health.dto.PatientRequestDto;
import io.health.dto.PatientResponseDto;
import io.health.entities.Patient;
import io.health.repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {
	
	@Autowired(required = true)
	private PatientRepo repo;

	@Override
	public PatientResponseDto addPatient(PatientRequestDto dto) {
		// TODO Auto-generated method stub
				Patient entity=Mapper.getPatient(dto);
				Patient retrivePatient=repo.save(entity);
				log.info("retrived data {}",retrivePatient);

		       return Mapper.getPatientResponse(retrivePatient);
	}
	




}
