package com.db.education.app.exception;

public class SaveException extends Exception {

    public SaveException() {
        super();
    }

    public SaveException(String message) {
        super(message);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveException(Throwable cause) {
        super(cause);
    }

    protected SaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
