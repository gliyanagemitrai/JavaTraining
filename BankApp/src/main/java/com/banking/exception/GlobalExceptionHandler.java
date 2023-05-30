package com.banking.exception;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<String> handleHttpException(ValidationException ex) {
    return ResponseEntity.status(ex.httpStatus).body(ex.message);
  }

  @ExceptionHandler(AccountNotFoundException.class)
  public ResponseEntity<String> handleHttpException2(AccountNotFoundException ex) {
    return ResponseEntity.status(ex.httpStatus).body( ex.message);
  }


}
