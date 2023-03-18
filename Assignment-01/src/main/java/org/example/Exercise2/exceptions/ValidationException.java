package org.example.Exercise2.exceptions;

public class ValidationException extends Exception{
    public ValidationException(String error) {
        super(error);
    }
}
