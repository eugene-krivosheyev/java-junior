package com.acme.edu.loggerexceptions;

public class LoggerException extends Exception {
    private LoggerErrors errorCode = LoggerErrors.OK;

    public LoggerException(String message) {
        super(message);
    }

    public LoggerException(String message, LoggerErrors errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public LoggerException(LoggerErrors errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public LoggerErrors getErrorCode() {
        return errorCode;
    }
    public int getErrorCodeOrdinal() {
        return errorCode.ordinal();
    }

    public void setErrorCode(LoggerErrors errorCode) {
        this.errorCode = errorCode;
    }
}
