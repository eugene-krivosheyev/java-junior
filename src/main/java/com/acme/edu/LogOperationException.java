package com.acme.edu;



public class LogOperationException extends Exception {
    public LogOperationException(String message) {
        super(message);
    }

    public LogOperationException(Throwable throwable){ super(throwable); }

    public LogOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
