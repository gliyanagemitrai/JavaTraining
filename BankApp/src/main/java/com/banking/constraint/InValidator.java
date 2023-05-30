package com.banking.constraint;

import com.banking.models.AccountType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class InValidator implements ConstraintValidator<In, String> {
  private String[] acceptedValues;
  @Override
  public void initialize(In constraintAnnotation) {
    this.acceptedValues = constraintAnnotation.acceptedValues();
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    Boolean isValid = false;
    for (String v : this.acceptedValues) {
      if (v.equalsIgnoreCase(value)) {
        isValid = true;
      }
    }
    return isValid;
  }
}
