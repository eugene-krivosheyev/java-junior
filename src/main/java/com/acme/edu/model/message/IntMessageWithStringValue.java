package com.acme.edu.model.message;

public class IntMessageWithStringValue extends MessageWithStringValue {

    public IntMessageWithStringValue(String value) {
        super(value);
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!canJoinMessage(message)) throw new IllegalStateException();
        return new IntMessageWithStringValue(String.valueOf(Integer.parseInt(this.getStringValue())
                + Integer.parseInt(((MessageWithStringValue)message).getStringValue())));
    }

    @Override
    public String toString() {
        return "primitive: " + getStringValue();
    }

    @Override
    public boolean canJoinMessage(Message message) {
        if (message instanceof IntMessageWithStringValue) {
            return Long.parseLong(this.getStringValue())
                    + Long.parseLong(((MessageWithStringValue)message).getStringValue()) < Integer.MAX_VALUE;
        }
        return false;
    }
}
