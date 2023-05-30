package com.banking.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;

public class HttpException  extends RuntimeException{
   long timestamp;
   String errorCode;
   String message;
   HttpStatus httpStatus;

  public HttpException( String errorCode, String message, HttpStatus httpStatus) {
    super(message);
    this.timestamp = new Date().getTime();
    this.errorCode = errorCode;
    this.message = message;
    this.httpStatus = httpStatus;

  }
}
