package com.banking.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends HttpException{

    public ValidationException(String errorCode, String message,
        HttpStatus httpStatus) {
        super( errorCode, message, httpStatus);
    }
}
