package com.acme.edu.exception;

public class FlushException extends  Exception{
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

    public FlushException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

