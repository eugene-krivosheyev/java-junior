package com.acme.edu;

import com.acme.edu.decorators.Decorator;
import com.acme.edu.decorators.StringDecorator;

public class StringMessage implements Message {
    private String value;
    private int numOfSequent;
    private static Decorator decorator = new StringDecorator();

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
        return  decorator.decorate("" + value, "" + numOfSequent);
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
