package com.acme.edu.exceptions;

import java.lang.reflect.Type;

public class TypeCommandException extends LogException {

    private String type;

    public TypeCommandException(String message) {
        super(message);
    }
    public TypeCommandException(String message, String type) {
        super(message);
        type = type;
    }

    public TypeCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeCommandException() {
        super();
    }

    public TypeCommandException(Throwable cause) {
        super(cause);
    }

    public String getType() {
        return type;
    }
}
