package com.acme.edu.ooad.message;

public class ByteMessage implements Message {
    private final String prefix;
    private byte value;
    public ByteMessage(byte value) {
        this.prefix = "primitive: ";
        this.value = value;
    }
    @Override
    public void clean() { value = 0; }
    @Override
    public String toString() { return prefix + value; }
    private byte getValue() {
        return value;
    }
    @Override
    public Message getNewInstance(Message message) {
        if (Message.sameType(this,message)) {
            return new ByteMessage((byte)(this.value+((ByteMessage)message).getValue()));
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
