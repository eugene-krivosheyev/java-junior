package com.acme.logger;

public class SavingException extends Exception {
    public SavingException(String message) {
        super(message);
    }

    public SavingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SavingException(Throwable cause) {
        super(cause);
    }
}
