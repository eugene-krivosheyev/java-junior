package com.acme.edu.messageexceptions;

public class OverflowException extends Exception {
    public OverflowException(String message) {
        super(message);
    }

    public OverflowException(Throwable cause) {
        super(cause);
    }

    public OverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
