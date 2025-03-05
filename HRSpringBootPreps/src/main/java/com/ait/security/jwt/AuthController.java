package com.ait.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		// Validate user credentials (this is just a basic example, use a service for authentication)
		if ("user".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
			return jwtUtil.generateToken(loginRequest.getUsername());
		} else {
			throw new UnauthorizedException("Invalid credentials");
		}
	}
}
