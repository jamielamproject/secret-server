package com.jamie.secret.jwt.security;

public interface ValidateTokenService {
	boolean validate_login_general(String token);
	
	boolean validate_registration_token(String token);
	
}