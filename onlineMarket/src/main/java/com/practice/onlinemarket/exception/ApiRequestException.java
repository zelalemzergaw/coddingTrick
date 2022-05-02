package com.practice.onlinemarket.exception;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException() {
    }

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
