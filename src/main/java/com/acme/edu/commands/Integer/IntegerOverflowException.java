package com.acme.edu.commands.Integer;

public class IntegerOverflowException extends RuntimeException {
    public IntegerOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerOverflowException(Throwable cause) {
        super(cause);
    }

    public IntegerOverflowException(String message) {
        super(message);
    }
}