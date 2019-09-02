package com.acme.edu.exceptions;

public class ConnectionException extends RuntimeException {
    public ConnectionException(Throwable throwable) {
        super(throwable);
    }
}
