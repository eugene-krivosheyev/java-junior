package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class ObjectMessage implements Message {
    private Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String getDecoratedString() {
        if (value == null) {
            return "null";
        }
        return "reference: " + value.toString();
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public Message accumulate(Message message) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of ObjectMessage");
        }
        return this;
    }
}
