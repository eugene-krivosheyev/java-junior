package com.acme.edu.loggerexceptions;

public class AccumulateException extends Exception{
    private static int code = 5;

    public int getCode(){
        return code;
    }

    public AccumulateException(String message) {
        super(message);
    }

    public AccumulateException(Throwable cause) {
        super(cause);
    }

    public AccumulateException(String message, Throwable cause) {
        super(message, cause);
    }
}
