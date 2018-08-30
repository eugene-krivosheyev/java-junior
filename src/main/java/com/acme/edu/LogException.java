package com.acme.edu;

/**
 * Created by Java_12 on 30.08.2018.
 */
public class LogException extends Exception {
    private int code;

    public LogException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public LogException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
