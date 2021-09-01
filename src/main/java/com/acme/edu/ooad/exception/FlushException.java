package com.acme.edu.ooad.exception;

public class FlushException extends Exception {
    public FlushException() {
    }

    public FlushException(String message) {
        super(message);
    }

    public FlushException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlushException(Throwable cause) {
        super(cause);
    }
}
