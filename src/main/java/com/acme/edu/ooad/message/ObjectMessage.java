package com.acme.edu.ooad.message;

import java.util.Objects;

public class ObjectMessage implements Message{
    private final String prefix;
    private final Object value;
    int counter;

    public ObjectMessage(Object value) {
        this.prefix = "reference: ";
        this.value = value;
    }

    @Override
    public void clean() {}

    @Override
    public String toString() { return prefix + value; }

    @Override
    public Message getNewInstance(Message message) {
        return message;
    }

    @Override
    public Message getInstanceToPrint(Message message) {
        return this;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof ObjectMessage) {
            if (this.value == ((ObjectMessage) anObject).value) {
                return true;
            }
        }
        return false;
    }
}
