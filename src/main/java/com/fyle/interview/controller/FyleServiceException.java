package com.fyle.interview.controller;

public class FyleServiceException extends Exception {
    public FyleServiceException(String message, Exception e) {
        super(message, e);
    }
}
