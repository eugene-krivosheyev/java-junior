package com.acme.edu.loggerexceptions;

public class AccumulationException extends Exception {
    private static int code = 5;

    public int getCode(){
        return code;
    }

    public AccumulationException(String message) {
        super(message);
    }

    public AccumulationException(Throwable cause) {
        super(cause);
    }

    public AccumulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
