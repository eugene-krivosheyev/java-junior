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
    public void clear() {
        value = null;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public void accumulate(Message message, Printer printer) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of ObjectMessage");
        }
        printer.print(this);
        value = ((ObjectMessage) message).value;
    }
}
