package io.health.exceptions;

import lombok.Data;
import lombok.Getter;

@Data
public class AadharInvalidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private Integer statusCode;
    private String statusMessage;
	
	public AadharInvalidException(Integer code,String message) {
	super(message);
	statusCode=code;
	statusMessage=message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
}
