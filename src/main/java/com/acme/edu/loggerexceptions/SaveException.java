package com.acme.edu.loggerexceptions;

public class SaveException extends SaverExceptions {
    private static int code = 2;

    public int getCode(){
        return code;
    }

    public SaveException(String message) {
        super(message);
    }

    public SaveException(Throwable cause) {
        super(cause);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
