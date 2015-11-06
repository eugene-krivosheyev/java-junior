package com.acme.edu;

public class DiviziobByZeroException extends Exception {
    public DiviziobByZeroException() {
        super();
    }

    public DiviziobByZeroException(String message) {
        super(message);
    }

    public DiviziobByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiviziobByZeroException(Throwable cause) {
        super(cause);
    }

    protected DiviziobByZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
