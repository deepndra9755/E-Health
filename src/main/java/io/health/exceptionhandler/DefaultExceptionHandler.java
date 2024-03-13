package io.health.exceptionhandler;

import io.health.exceptions.AadharInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import io.health.vo.response.ResponseVo;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(AadharInvalidException.class)
	public final ResponseEntity<Object> handleInvalidAadharException(AadharInvalidException ex){
		return new ResponseEntity<Object>(new ResponseVo(ex.getStatusCode(),ex.getMessage(),null), HttpStatus.OK);
	}
//
//	@ExceptionHandler(GeneralException.class)
//	public final ResponseEntity<Object> handleInvalidGeneralException(GeneralException ex){
//		return new ResponseEntity<Object>(new ResponseVo(ex.getStatusCode(),ex.getMessage(),null), HttpStatus.OK);
//	}
	
//	@ExceptionHandler(InvalidAadharException.class)
//	public final ResponseEntity<Object> handleInvalidAadharException(InvalidAadharException ex){
//		return new ResponseEntity<Object>(new ResponseVo(204,ex.getMessage(),null), HttpStatus.OK);
//	}
	
}
