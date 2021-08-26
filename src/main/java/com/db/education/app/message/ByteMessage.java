package com.db.education.app.message;

public class ByteMessage implements Message {
    private final MessageType type = MessageType.BYTE;
    private int value;

    public ByteMessage(byte value) {
        this.value = value;
    }

    /**
     * Accumulates Bytes and prevents overflow
     * */
    @Override
    public boolean accumulate(Message message) {
        byte msgValue = (byte) ((ByteMessage) message).value;
        this.value += msgValue;
        if (this.value > Byte.MAX_VALUE) {
            ((ByteMessage) message).value = this.value - Byte.MAX_VALUE;
            this.value = Byte.MAX_VALUE;
            return false;
        } else if (this.value < Byte.MIN_VALUE) {
            ((ByteMessage) message).value = this.value - Byte.MIN_VALUE;
            this.value = Byte.MIN_VALUE;
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "primitive: " + value + System.lineSeparator();
    }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }
}
