package com.acme.edu.exceptions;

public class SaverException extends Exception{
    public SaverException() {
    }

    public SaverException(String message) {
        super(message);
    }

    public SaverException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaverException(Throwable cause) {
        super(cause);
    }

    public SaverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
