package io.health.exceptions;

import lombok.Data;

@Data
public class PatientNotFoundException extends Exception {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String statusMessage;
   private Integer statusCode;
   
	
	public PatientNotFoundException(Integer statusCode,String statusMessage) {
		super(statusMessage);
		this.statusCode=statusCode;
		this.statusMessage=statusMessage;
	}

}
