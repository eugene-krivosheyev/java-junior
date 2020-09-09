package com.acme.edu.message;

public class ByteMessage implements LoggerMessage {
    public static final String PREFIX_PRIMITIVE = "primitive: ";

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

    @Override
    public boolean isNotOverflowed(LoggerMessage newMessage) {
        return true;
    }
}

