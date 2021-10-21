package com.acme.edu.model.message;


public class ByteMessageWithStringValue extends MessageWithStringValue {
    public ByteMessageWithStringValue(String value) {
        super(value);
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!canJoinMessage(message)) throw new IllegalStateException();
        String messageValue=((ByteMessageWithStringValue) message).getStringValue();
        return new ByteMessageWithStringValue(String.valueOf(Byte.parseByte(this.getStringValue()) + Byte.parseByte(messageValue)));
    }

    @Override
    public String toString() {
        return "primitive: " + getStringValue();
    }

    @Override
    public boolean canJoinMessage(Message message) {
        if (message instanceof ByteMessageWithStringValue) {
            String messageValue=((ByteMessageWithStringValue) message).getStringValue();
            return Long.parseLong(this.getStringValue()) + Long.parseLong(messageValue) < Byte.MAX_VALUE;
        }
        return false;
    }
}
