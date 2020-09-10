package com.acme.edu.message;

public class StringMessage implements Message {
    private int count;
    private String value;
    private String prefix = "string: ";

    public StringMessage(String value) {
        this.value = value;

    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public void updateAccumulator(Message message) {
        count++;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public boolean needFlush(Message message) {
        return !message.getValue().equals(value);
    }

    @Override
    public String toString() {
        String result = prefix + value;
        if (count > 0){
            result = result + " (x" + (++count) + ")";
        }
        return result;
    }
}
