package com.db.education.app.message;

public class BooleanMessage implements Message {
    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String toString() {
        return "primitive: " + value + System.lineSeparator();
    }
}
