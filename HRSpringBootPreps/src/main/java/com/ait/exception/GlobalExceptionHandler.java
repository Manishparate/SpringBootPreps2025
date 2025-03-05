package com.ait.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("error", e.getMessage());
		return new ResponseEntity<Object>(errorMap, HttpStatus.NOT_FOUND);
	}
}
