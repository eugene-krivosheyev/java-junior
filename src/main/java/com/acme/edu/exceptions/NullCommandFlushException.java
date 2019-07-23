package com.acme.edu.exceptions;

public class NullCommandFlushException extends Exception {
    public NullCommandFlushException() {
        super();
    }

    public NullCommandFlushException(String message) {
        super(message);
    }

    public NullCommandFlushException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullCommandFlushException(Throwable cause) {
        super(cause);
    }

    protected NullCommandFlushException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
