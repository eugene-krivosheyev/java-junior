package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

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
        ObjectMessage previousMessage = clone();
        value = ((ObjectMessage)message).value;
        return previousMessage;
    }

    @Override
    public ObjectMessage clone() {
        return new ObjectMessage(value);
    }
}
