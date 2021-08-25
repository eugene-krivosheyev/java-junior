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

    boolean isStateEquals(State currentState) {
        return State.INT.equals(currentState);
    }

    int accumulate(int sum) {
        return sum + value;
    }

    int getValue() {
        return value;
    }
}








