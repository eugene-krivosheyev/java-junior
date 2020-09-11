package com.acme.edu.exception;

public abstract class LoggerException extends Exception {
    public LoggerException(String message, Exception e) {
        super(message, e);
    }
}
