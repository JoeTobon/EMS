package com.collabera.jump.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler 
{
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> empNotFound(EmployeeNotFoundException e) 
	{

		ExceptionResponse response = new ExceptionResponse("ENF", e.getMessage());

		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ExceptionResponse> addNotFound(AddressNotFoundException e)
	{

		ExceptionResponse response = new ExceptionResponse("ANF", e.getMessage());

		return ResponseEntity.badRequest().body(response);
	}
}
