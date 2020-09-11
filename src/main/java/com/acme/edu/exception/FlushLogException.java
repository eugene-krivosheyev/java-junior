package com.acme.edu.exception;

public class FlushLogException extends LoggerException {
    public FlushLogException(String s, IndexOutOfBoundsException e) {
        super(s, e);
    }
}
