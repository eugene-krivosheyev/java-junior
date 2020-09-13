package com.acme.edu.exceptions;

public class SaveException extends Throwable {
    public SaveException(String message) {
        super(message);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveException() {
        super();
    }

    public SaveException(Throwable cause) {
        super(cause);
    }
}
