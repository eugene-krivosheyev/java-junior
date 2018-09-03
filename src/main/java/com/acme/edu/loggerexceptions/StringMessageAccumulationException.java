package com.acme.edu.loggerexceptions;

public class StringMessageAccumulationException extends AccumulationException {
    private static int code = 9;

    public int getCode(){
        return code;
    }

    public StringMessageAccumulationException(String message) {
        super(message);
    }

    public StringMessageAccumulationException(Throwable cause) {
        super(cause);
    }

    public StringMessageAccumulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
