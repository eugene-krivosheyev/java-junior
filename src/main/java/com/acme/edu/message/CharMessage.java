package com.acme.edu.message;

public class CharMessage extends LoggerMessage {
    public static final String PREFIX_CHAR = "char: ";

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}

