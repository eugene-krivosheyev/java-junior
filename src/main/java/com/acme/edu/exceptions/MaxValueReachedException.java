package com.acme.edu.exceptions;

public class MaxValueReachedException extends Exception {
    public MaxValueReachedException() {
        super();
    }

    public MaxValueReachedException(String message) {
        super(message);
    }

    public MaxValueReachedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxValueReachedException(Throwable cause) {
        super(cause);
    }

    protected MaxValueReachedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
