package com.db.edu;

public class LoggerException extends Exception {

    public LoggerException() {
        super();
    }

    public LoggerException(String message) {
        super(message);
    }

    public LoggerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggerException(Throwable cause) {
        super(cause);
    }
}
