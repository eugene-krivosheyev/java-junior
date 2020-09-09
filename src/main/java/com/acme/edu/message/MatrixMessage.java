package com.acme.edu.message;

public class MatrixMessage implements LoggerMessage {
    public static final String PREFIX_MATRIX = "primitives matrix: ";

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
        return false;
    }
}

