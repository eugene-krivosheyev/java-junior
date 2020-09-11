package com.acme.edu.exception;

public class BufferOverflowException extends IllegalArgumentException{
    public BufferOverflowException() {
    }

    public BufferOverflowException(String s) {
        super(s);
    }

    public BufferOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public BufferOverflowException(Throwable cause) {
        super(cause);
    }
}

