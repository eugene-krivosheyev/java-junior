package com.acme.edu.ooad.message;

import java.util.Objects;

public class CharMessage implements Message {
    final String prefix;
    final char value;
    int counter;

    public CharMessage(char value) {
        this.prefix = "char: ";
        this.value = value;
    }

    @Override
    public void clean() {}

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
    public String getBody() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof CharMessage) {
            if (this.value == ((CharMessage) anObject).value) {
                return true;
            }
        }
        return false;
    }
}
