package com.ait.security.jwt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException e) {
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Object>(errorMap, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(TokenSignatureException.class)
	public ResponseEntity<Object> handleTokenSignatureException(TokenSignatureException e) {
		System.err.println("----------SignatureException----------");
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Object>(errorMap, HttpStatus.UNAUTHORIZED);
	}

}
