package com.acme.edu;

public class FlushException extends Exception{

    public FlushException() {
        super();
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

    protected FlushException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
