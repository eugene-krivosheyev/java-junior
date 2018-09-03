package com.acme.edu.loggerexceptions;

public class OverflowAccumulationException extends AccumulationException {
    private static int code = 8;

    public int getCode(){
        return code;
    }

    public OverflowAccumulationException(String message) {
        super(message);
    }

    public OverflowAccumulationException(Throwable cause) {
        super(cause);
    }

    public OverflowAccumulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
