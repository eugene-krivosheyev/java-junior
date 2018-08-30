package com.acme.edu.loggerexceptions;

public class AccumulatingException extends LoggerException {

    public AccumulatingException(String message) {
        super(message);
    }

    public AccumulatingException(String message, LoggerErrors errorCode) {
        super(message, errorCode);
    }

    public AccumulatingException(LoggerErrors errorCode) {
        super(errorCode);
    }

    public AccumulatingException(LoggerErrors errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public AccumulatingException(String message, LoggerErrors errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
