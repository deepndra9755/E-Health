package io.health.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.health.exceptions.AadharInvalidException;
import io.health.exceptions.GeneralException;
import io.health.vo.response.ResponseVo;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AadharInvalidException.class)
	public final ResponseEntity<Object> handleInvalidAadharException(AadharInvalidException ex){
		return new ResponseEntity<Object>(new ResponseVo(8099,ex.getMessage(),null), HttpStatus.OK);
	}
	
	@ExceptionHandler(GeneralException.class)
	public final ResponseEntity<Object> handleInvalidGeneralException(GeneralException ex){
		return new ResponseEntity<Object>(new ResponseVo(8099,ex.getMessage(),null), HttpStatus.OK);
	}
	
}
