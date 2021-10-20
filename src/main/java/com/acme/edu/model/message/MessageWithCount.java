package com.acme.edu.model.message;

import com.acme.edu.model.MessageType;

public class MessageWithCount extends Message {
    private int counter = 1;

    public MessageWithCount(MessageType type, String value) {
        super(type, value);
    }

    @Override
    public void addValue(String value) {
        if (!value.equals(getValue())) throw new IllegalStateException();
        counter++;
    }

    @Override
    public String toString() {
        return super.toString() + " (x" + counter + ")";
    }
}
