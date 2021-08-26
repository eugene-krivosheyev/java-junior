package com.acme.edu.ooad.message;

import java.util.Objects;

public class ByteMessage implements AccumulativeMessage {
    private final String prefix;
    private byte value;
    public ByteMessage(byte value) {
        this.prefix = "primitive: ";
        this.value = value;
    }
    @Override
    public void clean() { value = 0; };
    @Override
    public Message process(Message message) {
        if (this.sameTypeOf(message)) {
            ByteMessage updatedMessage = new ByteMessage((byte)(this.value+(byte)message.getValue()));
            return updatedMessage;
        } else {
            return message;
        }
    };
    @Override
    public String toString() { return prefix + value; }
    @Override
    public boolean isNeedToFlush(Message message) { return false; }
    @Override
    public Object getValue() {
        return value;
    }
    @Override
    public boolean equalValues(Message message) {
        return Objects.equals(this.value, message.getValue());
    }
    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }
}
