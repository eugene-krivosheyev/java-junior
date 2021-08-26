package com.acme.edu.ooad.message;

import java.util.Objects;

public class IntegerMessage implements AccumulativeMessage {
    private final String prefix;
    private int value;
    public IntegerMessage(int value) {
        this.prefix = "primitive: ";
        this.value = value;
    }
    @Override
    public void clean() { value = 0; };
    @Override
    public Message process(Message message) {
        if (this.sameTypeOf(message)) {
            IntegerMessage updatedMessage = new IntegerMessage(this.value+(int)message.getValue());
            return updatedMessage;
        } else {
            return message;
        }
    }
    @Override
    public String toString() { return prefix + value; }
    @Override
    public boolean isNeedToFlush(Message message) {return false;}
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
        return message instanceof IntegerMessage;
    }
}
