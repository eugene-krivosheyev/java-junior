package com.acme.edu.exception;

/**
 * Abstract class for all exceptions that can be thrown due to logger work.
 */
public abstract class LoggerException extends Exception {
    public LoggerException(String message, Exception e) {
        super(message, e);
    }
}
