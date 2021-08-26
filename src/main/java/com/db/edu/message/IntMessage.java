package com.db.edu.message;

public class IntMessage {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private int flag = 0;
    private int value;

    public IntMessage(int value) {
        this.value = value;
    }

    public void accumulate(IntMessage message) {
        value += message.getValue();
        flag = 1;
    }

    public String decoratedInt() {
        return PRIMITIVE_PREFIX + value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return flag == 0;
    }

    public void flush() {
        value = 0;
        flag = 0;
    }
}








