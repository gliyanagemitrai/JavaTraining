package com.banking.services;

import com.banking.exception.ValidationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ValidationService {

 public static final void validate(BindingResult result) throws JsonProcessingException {
   HashMap<String, String> errors = new HashMap<>();
   if (result.hasErrors()) {
     for (FieldError fieldError : result.getFieldErrors()) {
       errors.put(fieldError.getField(), fieldError.getDefaultMessage());
     }
     HashMap<String, HashMap<String, String>> errorBag = new HashMap<>();
     errorBag.put("errors", errors);
     String json = new ObjectMapper().writeValueAsString(errorBag);

     throw new ValidationException("validation error", json, HttpStatus.UNPROCESSABLE_ENTITY);
   }
 }

}
