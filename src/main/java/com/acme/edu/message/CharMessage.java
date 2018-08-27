package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class CharMessage extends Message {
    private char message;

    public CharMessage(char message, Decorator decorator) {
        super(decorator);
        this.message = message;
    }
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        getDecorator().setMessage(Character.toString(message));
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
