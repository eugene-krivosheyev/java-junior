package com.acme.edu.saver;

public class SavingException extends Exception {
    private int exceptionCode = 0;
    public SavingException() {
        super();
    }

    public SavingException(String message, Throwable cause, int exceptionCode) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }

    public SavingException(int code) {
        super();
        exceptionCode = code;
    }

    public SavingException(String message) {
        super(message);
    }

    public SavingException(String message, int code) {
        super(message);
        exceptionCode = code;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}
