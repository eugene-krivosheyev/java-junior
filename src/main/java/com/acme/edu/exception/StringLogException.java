package com.acme.edu.exception;

public class StringLogException extends Exception{
    public StringLogException(String message) {
        super(message);
    }

    public StringLogException(String message, Throwable cause) {
        super(message, cause);
    }
}
