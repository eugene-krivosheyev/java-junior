package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.saver.Saver;

import java.util.Objects;

public class StringMessage extends Message {
    private String message;
    private Saver saver;
    private int amount = 1;
    public StringMessage (String message, Saver saver, Decorator decorator) {
        super(saver, decorator);
        this.message = message;
        this.saver = saver;
    }
    @Override
    public Message log(Message message) {
        return null;
    }
    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof StringMessage;
    }
    @Override
    public void flush() {

    }
    @Override
    public void accumulate(Message message) throws MessageException {
        String value = ((StringMessage)message).message;
        if (Objects.equals(value, this.message)) {
            this.amount++;
        } else {
            this.flush();
            try {
                this.saver.save(fetch());
            } catch (Exception e) {
                e.printStackTrace();
                throw new MessageException(e);
            }
            this.message = value;
            this.amount = 1;
        }
    }
    public String fetch() {
        return getDecorator().decorate(message + (this.amount == 1 ? "" : " (x" + Integer.toString(amount) + ")")) + System.lineSeparator();
    }
}

