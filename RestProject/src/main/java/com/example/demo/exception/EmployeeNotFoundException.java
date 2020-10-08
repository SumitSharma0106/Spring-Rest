package com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2989391619175454171L;

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}
	

}
