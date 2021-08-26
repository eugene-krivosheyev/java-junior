package com.db.edu;

public class IntMessage {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private final int value;

    public IntMessage(int value) {
        this.value = value;
    }

    String decoratedInt() {
        return PRIMITIVE_PREFIX + value;
    }

    int getValue() {
        return value;
    }
}








