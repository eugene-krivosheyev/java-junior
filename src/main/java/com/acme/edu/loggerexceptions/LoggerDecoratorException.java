package com.acme.edu.loggerexceptions;

public class LoggerDecoratorException extends LoggerException {
    public LoggerDecoratorException(String message) {
        super(message);
    }

    public LoggerDecoratorException(String message, LoggerErrors errorCode) {
        super(message, errorCode);
    }

    public LoggerDecoratorException(LoggerErrors errorCode) {
        super(errorCode);
    }
}
