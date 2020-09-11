package com.acme.edu.exceptions;

public class FileLoggerSaverException extends Exception {

    public FileLoggerSaverException() {
    }

    public FileLoggerSaverException(String message) {
        super(message);
    }

    public FileLoggerSaverException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileLoggerSaverException(Throwable cause) {
        super(cause);
    }

    public FileLoggerSaverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
