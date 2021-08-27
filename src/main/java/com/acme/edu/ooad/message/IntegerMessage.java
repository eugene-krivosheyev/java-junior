package com.acme.edu.ooad.message;

import java.util.Objects;

public class IntegerMessage implements Message {
    private final String prefix;
    private int value;
    public IntegerMessage(int value) {
        this.prefix = "primitive: ";
        this.value = value;
    }
    @Override
    public void clean() { value = 0; };
    @Override
    public String toString() { return prefix + value; }
    @Override
    public Object getValue() {
        return value;
    }
    @Override
    public boolean equalValues(Message message) {
        return Objects.equals(this.value, message.getValue());
    }
    @Override
    public Message getNewInstance(Message message) {
        if (Message.sameType(this,message)) {
            IntegerMessage updatedMessage = new IntegerMessage(this.value+(int)message.getValue());
            return updatedMessage;
        } else {
            return message;
        }
    }
    @Override
    public Message getInstanceToPrint(Message message) {
        if (Message.sameType(this,message)) return null;
        return this;
    }
}
