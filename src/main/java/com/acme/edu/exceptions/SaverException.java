package com.acme.edu.exceptions;

import java.io.IOException;

public class SaverException extends IOException {
    public SaverException() {
        super();
    }

    public SaverException(String message) {
        super(message);
    }

    public SaverException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaverException(Throwable cause) {
        super(cause);
    }
}
