package io.health.exceptions;

public class PatientNotFoundException extends Exception {
	
	public PatientNotFoundException(String msg,String statusCode) {
		super(statusCode);
	}

}
