package com.ait.security.jwt;

public class TokenSignatureException extends RuntimeException {

	public TokenSignatureException() {
		super();
	}

	public TokenSignatureException(String error) {
		super(error);
	}

}
