package io.health.exceptions;

import lombok.Data;

@Data
public class AadharInvalidException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer statusCode;
    private String statusMessage;
	
	public AadharInvalidException(Integer code,String message) {
	super(message);
	statusCode=code;
	statusMessage=message;
	}
}
