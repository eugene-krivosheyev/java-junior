package com.acme.edu.saver;

public class SaveException extends Exception {

    public SaveException(String exceptionText) {
        super(exceptionText);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
