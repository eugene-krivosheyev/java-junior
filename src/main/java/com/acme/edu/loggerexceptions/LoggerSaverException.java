package com.acme.edu.loggerexceptions;

public class LoggerSaverException extends SaverException {
    private static int code = 2;

    public int getCode(){
        return code;
    }

    public LoggerSaverException(String message) {
        super(message);
    }

    public LoggerSaverException(Throwable cause) {
        super(cause);
    }

    public LoggerSaverException(String message, Throwable cause) {
        super(message, cause);
    }
}
