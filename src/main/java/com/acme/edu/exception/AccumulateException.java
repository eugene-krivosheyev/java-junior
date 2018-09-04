package com.acme.edu.exception;

public class AccumulateException extends Exception {
    public AccumulateException() {
        super();
    }

    public AccumulateException(String message) {
        super(message);
    }

    public AccumulateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccumulateException(Throwable cause) {
        super(cause);
    }

    protected AccumulateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
