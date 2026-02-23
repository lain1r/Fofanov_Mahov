package org.example.bank;

public class InvalidAmountException extends IllegalArgumentException {
    public InvalidAmountException(String message) {
        super(message);
    }
}