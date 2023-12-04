package io.health.service.mapper;

import io.health.dto.PatientRequestDto;
import io.health.entities.Patient;

public class Mapper {
    public static final Patient getPatient(PatientRequestDto patientRequestDto){
      return new Patient(patientRequestDto.getAadharNumber(),patientRequestDto.getName(),patientRequestDto.getLastName(),patientRequestDto.getAddress(),patientRequestDto.getMobile(),patientRequestDto.getDate());
    }
}
