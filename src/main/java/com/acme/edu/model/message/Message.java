package com.acme.edu.model.message;

import com.acme.edu.model.MessageType;

public abstract class Message {
    private final MessageType type;
    private String value;

    public Message(MessageType type, String value) {
        this.type = type;
        this.value = value;
    }

    public MessageType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.getPrefix() + value;
    }

    public abstract void addValue(String value);

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
