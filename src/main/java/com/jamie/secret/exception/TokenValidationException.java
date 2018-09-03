package com.jamie.secret.exception;

public class TokenValidationException extends RuntimeException {
    public TokenValidationException(String msg) {
        super(msg);
    }
}