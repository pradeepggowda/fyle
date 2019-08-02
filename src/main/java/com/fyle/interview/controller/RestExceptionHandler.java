package com.fyle.interview.controller;

import com.fyle.interview.security.jwt.InvalidJwtAuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {FyleServiceException.class})
    public ResponseEntity genericExceptionHandler(Exception ex, WebRequest request) {
        return status(500).body(ex.getMessage());
    }

    @ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {
        return status(UNAUTHORIZED).body(ex.getMessage());
    }


    @ExceptionHandler(value = {FyleArgumentValidationException.class})
    public ResponseEntity invalidArgAuthentication(FyleArgumentValidationException ex, WebRequest request) {
        return status(BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity invalidArgAuthentication(BadCredentialsException ex, WebRequest request) {
        return status(UNAUTHORIZED).body(ex.getMessage());
    }
}
