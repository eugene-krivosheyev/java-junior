package com.acme.edu.exceptions;

public class LogException extends Throwable {

    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException() {
        super();
    }

    public LogException(Throwable cause) {
        super(cause);
    }
}
