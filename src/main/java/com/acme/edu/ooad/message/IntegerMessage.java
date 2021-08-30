package com.acme.edu.ooad.message;

import java.util.Objects;

public class IntegerMessage implements Message {
    final String prefix;
    int value;
    int counter;

    public IntegerMessage(int value) {
        this.prefix = "primitive: ";
        this.value = value;
    }

    @Override
    public void clean() { value = 0; }

    @Override
    public String toString() { return prefix + value; }

    @Override
    public Message getNewInstance(Message message) {
        if (Message.sameType(this,message)) {
            return new IntegerMessage(this.value+((IntegerMessage)message).value);
        } else {
            return message;
        }
    }
    @Override
    public Message getInstanceToPrint(Message message) {
        if (Message.sameType(this,message)) return null;
        return this;
    }

    @Override
    public String getBody() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof IntegerMessage) {
            if (this.value == ((IntegerMessage) anObject).value) {
                return true;
            }
        }
        return false;
    }
}
