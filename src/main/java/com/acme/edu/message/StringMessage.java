package com.acme.edu.message;

public class StringMessage extends Message {

    private int counter = 1;

    private final String value;

    public StringMessage(String value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        if (message instanceof  StringMessage) {
            return ((StringMessage) message).value.equals(this.value);
        }
        return false;
    }

    @Override
    public void process(Message message) {
        this.counter++;
    }

    @Override
    public String decorate() {
        return "string: " + this.value + " (x" + this.counter + ")";
    }
}
