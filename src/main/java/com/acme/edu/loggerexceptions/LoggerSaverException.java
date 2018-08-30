package com.acme.edu.loggerexceptions;


public class LoggerSaverException extends LoggerException {
    public LoggerSaverException(String errorMessage) {
        super(errorMessage);
    }

    public LoggerSaverException(String errorMessage, LoggerErrors errorCode) {
        super(errorMessage, errorCode);
    }

}
