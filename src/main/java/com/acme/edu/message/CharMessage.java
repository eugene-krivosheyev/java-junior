package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.saver.Saver;

import java.util.Objects;

public class CharMessage extends Message {
    private char message;
    private int amount = 1;
    public CharMessage (char message, Saver saver, Decorator decorator) {
        super(saver, decorator);
        this.message = message;
    }
    @Override
    public Message log(Message message) {
        return null;
    }
    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof CharMessage;
    }
    @Override
    public void flush() {

    }
    @Override
    public void accumulate(Message message) {
        char value = ((CharMessage)message).message;
        if (Objects.equals(value, this.message)) {
            this.amount++;
        } else {
            this.flush();
            this.message = value;
            this.amount = 1;
        }

    }
    public String fetch() {
        return getDecorator().decorate(message) + System.lineSeparator();
    }
}