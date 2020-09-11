package com.acme.edu.exception;

public class SaveException extends LoggerException {
    public SaveException(String s, Exception e) {
        super(s, e);
    }
}
