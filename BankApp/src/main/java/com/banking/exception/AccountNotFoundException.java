package com.banking.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends ValidationException {

  public AccountNotFoundException(String errorCode, String message,
      HttpStatus httpStatus) {
    super(errorCode, message, httpStatus);

  }
}
