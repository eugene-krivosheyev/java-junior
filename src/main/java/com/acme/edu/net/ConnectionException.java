package com.acme.edu.net;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message, Throwable cause) { super(message, cause); }

    public ConnectionException(String message) { super(message); }

    public ConnectionException(Throwable cause) { super(cause); }
}
