package com.acme.edu.message;

public class MatrixMessage extends LoggerMessage {
    public static final String PREFIX_MATRIX = "primitives matrix: ";

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}

