package com.acme.edu.loggerexceptions;

public abstract class SaverExceptions extends Exception {
    private static int code;

    public abstract int getCode();

    public SaverExceptions(String message) {
        super(message);
    } ;

    public SaverExceptions(Throwable cause) {
        super(cause);
    }

    public SaverExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}