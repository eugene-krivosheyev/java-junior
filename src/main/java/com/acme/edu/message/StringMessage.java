package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;

public class StringMessage implements Message {
    private String value;
    private int numOfSequent;
    private Decorator decorator;

    public StringMessage(String value, int numOfSequent, Decorator decorator) {
        this.value = value;
        this.numOfSequent = numOfSequent;
        this.decorator = decorator;
    }

    public StringMessage(String value, Decorator decorator) {
        this.value = value;
        this.numOfSequent = 1;
        this.decorator = decorator;
    }

    @Override
    public String decorate() {
        return  decorator.decorate("" + value, "" + numOfSequent);
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(value, numOfSequent + ((StringMessage)message).numOfSequent, decorator);
    }

    @Override
    public boolean isSameType(Message message) {
        if (message instanceof StringMessage && !value.equals(((StringMessage)message).value)) {
            return  false;
        }
        return message instanceof StringMessage;
    }
}
