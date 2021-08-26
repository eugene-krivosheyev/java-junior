package com.acme.edu.ooad.message;

import java.util.Objects;

public class StringMessage implements AccumulativeMessage {
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
    public boolean isNeedToFlush(Message message){
        return repeatableStringCounter != 0 && !equalValues(message);
    }
    @Override
    public String toString() {
        return prefix + value + (repeatableStringCounter > 1 ? " (x" + repeatableStringCounter + ")" : "");
    }
    @Override
    public Message process(Message message) {
        if (this.sameTypeOf(message) && this.equalValues(message)) {
            int newCounter = this.repeatableStringCounter+1;
            return new StringMessage(this.value,newCounter);
        } else {
            return message;
        }
    }
    @Override
    public void clean() {
        repeatableStringCounter = 0;
    }
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
        return message instanceof StringMessage;
    }
}
