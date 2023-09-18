package io.health.exceptions;

import lombok.Data;

@Data
public class GeneralException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer statusCode;
    private String statusMessage;
	public GeneralException(Integer statusCode ,String statusMessage) {
		super(statusMessage);
		this.statusCode=statusCode;
		this.statusMessage=statusMessage;
	}

}
