package com.acme.edu.ooad.message;

import java.util.Objects;

public class StringMessage implements Message {
    private final String prefix;
    private final String value;
    private int repeatableStringCounter;

    public StringMessage(String value) {
        this.prefix = "string: ";
        this.value = value;
        this.repeatableStringCounter = 1;
    }
    private StringMessage(String value, int counter) {
        this.prefix = "string: ";
        this.value = value;
        this.repeatableStringCounter = counter;
    }
    @Override
    public String toString() {
        return prefix + value + (repeatableStringCounter > 1 ? " (x" + repeatableStringCounter + ")" : "");
    }
    @Override
    public void clean() {
        repeatableStringCounter = 0;
    }
    private String getValue() {
        return value;
    }
    private boolean equalValues(Message message) {
        return Objects.equals(this.value, ((StringMessage)message).getValue());
    }
    @Override
    public Message getNewInstance(Message message) {
        if (Message.sameType(this, message) && this.equalValues(message)) {
            int newCounter = this.repeatableStringCounter+1;
            return new StringMessage(this.value,newCounter);
        } else {
            return message;
        }
    }
    @Override
    public Message getInstanceToPrint(Message message) {
        if (Message.sameType(this, message) && this.equalValues(message)) return null;
        return this;
    }
}
