package com.db.edu;

public class StringMessage {
    private static final String STRING_PREFIX = "string: ";
    private final String value;

    public StringMessage(String value) {
        this.value = value;
    }

    String decoratedString(int quantityString) {
        if (quantityString == 1) {
            return STRING_PREFIX + value;
        } else {
            return STRING_PREFIX + value + " (x" + quantityString + ")";
        }
    }

    boolean isStateEquals(State currentState) {
        return State.STRING.equals(currentState);
    }

    int accumulate(int accumulateBuffer) {
        return ++accumulateBuffer;
    }

    String getValue() {
        return value;
    }

}