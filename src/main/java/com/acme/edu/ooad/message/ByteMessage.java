package com.acme.edu.ooad.message;

import java.util.Objects;

public class ByteMessage implements Message {
    private final String prefix;
    private byte value;
    public ByteMessage(byte value) {
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
            ByteMessage updatedMessage = new ByteMessage((byte)(this.value+(byte)message.getValue()));
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
