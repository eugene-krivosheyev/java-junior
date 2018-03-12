package com.acme.edu.exception;

public class SaveOperationException extends Exception {
    public SaveOperationException() {
        super();
    }

    public SaveOperationException(String message) {
        super(message);
    }

    public SaveOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveOperationException(Throwable cause) {
        super(cause);
    }

    protected SaveOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
