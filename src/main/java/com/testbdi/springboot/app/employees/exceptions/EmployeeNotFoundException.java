package com.testbdi.springboot.app.employees.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends ResponseStatusException{
	
	public EmployeeNotFoundException (String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
	

}
