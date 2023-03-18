package org.example.Exercise2.exceptions;

public class BalanceNotEnoughException extends Exception {
    public BalanceNotEnoughException(String currentBalanceIsNotEnough) {
        super(currentBalanceIsNotEnough);
    }

}
