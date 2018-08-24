package com.acme.edu;

public class StringMessage implements Message {
    private String value;
    private int numOfSequent;

    public StringMessage(String message) {
        this.value = message;
        this.numOfSequent = 1;
    }

    public StringMessage(String message, int numOfSequent) {
        this.value = message;
        this.numOfSequent = numOfSequent;
    }

    @Override
    public String decorate() {
        return "string: " + value + " (x" + numOfSequent + ")";
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(value, numOfSequent + ((StringMessage)message).numOfSequent);
    }

    @Override
    public boolean isSameType(Message message) {
        if (message instanceof StringMessage && !value.equals(((StringMessage)message).value)) {
            return  false;
        }
        return message instanceof StringMessage;
    }
}
