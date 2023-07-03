package io.health.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.health.entities.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	
	public Optional<Patient> findByAadharNumber(String aadharNumber);

}
