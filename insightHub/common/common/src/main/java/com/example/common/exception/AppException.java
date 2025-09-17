package com.example.common.exception;

public class AppException extends RuntimeException{
    private final String errorCode;

    public AppException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    private String getErrorCode() {
        return errorCode;
    }
}
