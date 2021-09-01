package com.acme.edu.ooad.message;

public class ByteMessage implements Message {
    final String prefix;
    byte value;
    int counter;

    public ByteMessage(byte value) {
        this.prefix = "primitive: ";
        this.value = value;
    }

    @Override
    public void clean() {
        value = 0;
    }

    @Override
    public String toString() {
        return prefix + value;
    }

    @Override
    public Message getNewInstance(Message message) {
        if (Message.sameType(this, message)) {
            return new ByteMessage((byte) (this.value + ((ByteMessage) message).value));
        } else {
            return message;
        }
    }

    @Override
    public Message getInstanceToPrint(Message message) {
        if (Message.sameType(this, message)) return null;
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
        if (anObject instanceof ByteMessage) {
            return this.value == ((ByteMessage) anObject).value;
        }
        return false;
    }
}
