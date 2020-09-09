package com.acme.edu.message;

public class ObjectMessage extends LoggerMessage {
    public static final String PREFIX_REFERENCE = "reference: ";

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}

