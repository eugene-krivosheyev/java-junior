package com.acme.edu.loggerexceptions;

public class LoggingException extends LoggerException {
    public LoggingException(String message) {
        super(message);
    }

    public LoggingException(String message, LoggerErrors errorCode) {
        super(message, errorCode);
    }

    public LoggingException(LoggerErrors errorCode) {
        super(errorCode);
    }

    public LoggingException(LoggerErrors errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public LoggingException(String message, LoggerErrors errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
