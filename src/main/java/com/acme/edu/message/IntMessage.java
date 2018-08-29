package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.saver.Saver;

public class IntMessage extends Message {
    private int message;
    public IntMessage (int message, Saver saver, Decorator decorator) {
        super(saver, decorator);
        this.message = message;
    }
    @Override
    public Message log(Message message) {
        return null;
    }
    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }
    public void flush() {

    }
    @Override
    public void accumulate(Message message) {
        int value = ((IntMessage)message).message;
        this.message += value;
    }
    @Override
    public String fetch() {
        return getDecorator().decorate(message) + System.lineSeparator();
    }
}
