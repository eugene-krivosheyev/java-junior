package com.acme.edu.exceptions;

public class SaverException extends RuntimeException {
    public SaverException(String message, Throwable cause) {
        super(message, cause);
    }
}
