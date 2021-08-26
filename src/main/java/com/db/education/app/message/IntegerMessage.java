package com.db.education.app.message;

public class IntegerMessage implements Message {
    private final MessageType type = MessageType.INT;
    private long value;

    public IntegerMessage(int value) {
        this.value = value;
    }

    /**
     * Accumulates Integers and prevents overflow
     * */
    @Override
    public boolean accumulate(Message message) {
        int msgValue = (int)((IntegerMessage)message).value;
        this.value += msgValue;
        if (this.value > Integer.MAX_VALUE) {
            ((IntegerMessage)message).value = this.value - Integer.MAX_VALUE;
            this.value = Integer.MAX_VALUE;
            return false;
        } else if (this.value < Integer.MIN_VALUE) {
            ((IntegerMessage)message).value = this.value - Integer.MIN_VALUE;
            this.value = Integer.MIN_VALUE;
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
