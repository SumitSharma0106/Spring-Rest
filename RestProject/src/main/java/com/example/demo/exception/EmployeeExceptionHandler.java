package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeExceptionResponse> handleException(EmployeeNotFoundException exc){
		
		EmployeeExceptionResponse error=new EmployeeExceptionResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeExceptionResponse> handleException(Exception exc){
		
		EmployeeExceptionResponse error=new EmployeeExceptionResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Enter right id");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
