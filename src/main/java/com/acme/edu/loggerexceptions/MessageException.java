package com.acme.edu.loggerexceptions;

public class MessageException extends SaverExceptions {
    private static int code = 3;

    public int getCode(){
        return code;
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
