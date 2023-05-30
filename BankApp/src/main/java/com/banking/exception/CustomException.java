package com.banking.exception;

import org.springframework.http.HttpStatus;

public class CustomException  extends HttpException{

    public CustomException(String errorCode, String message,
        HttpStatus httpStatus) {
        super( errorCode, message, httpStatus);
    }
}
