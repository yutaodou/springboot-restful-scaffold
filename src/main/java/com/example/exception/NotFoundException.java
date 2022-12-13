package com.example.exception;

public class NotFoundException extends ApplicationException {
    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
