package com.fyle.interview.controller;

import com.fyle.interview.security.jwt.InvalidJwtAuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {FyleServiceException.class})
    public ResponseEntity genericExceptionHandler(Exception ex, WebRequest request) {
        return status(500).body(ex.getMessage());
    }

    @ExceptionHandler(value = {InvalidJwtAuthenticationException.class, UsernameNotFoundException.class})
    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {
        return status(UNAUTHORIZED).body(ex.getMessage());
    }
}
