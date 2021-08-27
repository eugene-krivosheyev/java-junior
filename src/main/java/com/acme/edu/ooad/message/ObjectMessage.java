package com.acme.edu.ooad.message;

import java.util.Objects;

public class ObjectMessage implements Message{
    private final String prefix;
    private final Object value;

    public ObjectMessage(Object value) {
        this.prefix = "reference: ";
        this.value = value;
    }
    @Override
    public void clean() {};
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
        return message;
    }
    @Override
    public Message getInstanceToPrint(Message message) {
        return this;
    }
}
