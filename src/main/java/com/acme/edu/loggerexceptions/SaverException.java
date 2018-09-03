package com.acme.edu.loggerexceptions;

public abstract class SaverException extends Exception {
    private static int code;

    public abstract int getCode();

    public SaverException(String message) {
        super(message);
    } ;

    public SaverException(Throwable cause) {
        super(cause);
    }

    public SaverException(String message, Throwable cause) {
        super(message, cause);
    }
}