package com.acme.edu.message;

public class ObjectMessage implements LoggerMessage {
    public static final String PREFIX_REFERENCE = "reference: ";

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }

    @Override
    public LoggerMessage accumulate(LoggerMessage newMessage) {
        return null;
    }
}

