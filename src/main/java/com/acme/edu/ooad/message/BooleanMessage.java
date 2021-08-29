package com.acme.edu.ooad.message;

public class BooleanMessage implements Message {
    final String prefix;
    final boolean value;
    int counter;

    public BooleanMessage(boolean value) {
        this.prefix = "primitive: ";
        this.value = value;
    }

    @Override
    public void clean() {
    }

    @Override
    public String toString() {
        return prefix + value;
    }

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
        if (anObject instanceof BooleanMessage) {
           if (this.value == ((BooleanMessage) anObject).value) {
               return true;
            }
        }
        return false;
    }
}