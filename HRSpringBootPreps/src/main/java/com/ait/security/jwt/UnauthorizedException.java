package com.ait.security.jwt;

public class UnauthorizedException extends RuntimeException {
	
	public UnauthorizedException(String message) {
		super(message);
	}
}
