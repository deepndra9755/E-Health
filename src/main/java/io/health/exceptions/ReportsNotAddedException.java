package io.health.exceptions;

import lombok.Data;

@Data
public class ReportsNotAddedException  extends Exception{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String statusMessage;
	private Integer statusCode;
	
	public ReportsNotAddedException(Integer statusCode,String statusMessage) {
		super(statusMessage);
		this.statusCode=statusCode;
		this.statusMessage=statusMessage;
	}
	
	

}
