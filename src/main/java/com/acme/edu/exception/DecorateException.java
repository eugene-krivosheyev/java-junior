package com.acme.edu.exception;

public class DecorateException extends Exception {
    public DecorateException() {
        super();
    }

    public DecorateException(String message) {
        super(message);
    }

    public DecorateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecorateException(Throwable cause) {
        super(cause);
    }

    protected DecorateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
