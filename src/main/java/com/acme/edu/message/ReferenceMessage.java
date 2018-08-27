package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class ReferenceMessage extends  Message {
    private Object message;

    public ReferenceMessage(Object message, Decorator decorator) {
        super(decorator);
        this.message = message;
    }
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        getDecorator().setMessage(message.toString());
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
