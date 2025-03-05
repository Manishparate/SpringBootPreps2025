package com.ait.security.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.security.Key;

@Component
public class JwtUtil {

	private Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Secure key for HS256

	public String generateToken(String username) {
		System.err.println("----------Token Generating----------");
		String compact = Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60)) // 1 hr
				.signWith(secretKey) // Using the secure key
				.compact();
		return compact;
	}

	public Claims extractClaims(String token) {
		try {
			JwtParser parser = Jwts.parserBuilder().setSigningKey(secretKey).build();
			Claims body = parser.parseClaimsJws(token).getBody();
			return body;
		} catch (SignatureException e) {
			throw new TokenSignatureException(
					"JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
		}
	}

	public String extractUsername(String token) throws SignatureException {
		String subject = extractClaims(token).getSubject();
		return subject;
	}

	public boolean isTokenExpired(String token) {
		boolean before = extractClaims(token).getExpiration().before(new Date());
		return before;
	}

	public boolean validateToken(String token, String username) {
		System.err.println("----------Token Validating----------");
		return (username.equals(extractUsername(token)) && !isTokenExpired(token));
	}
}
