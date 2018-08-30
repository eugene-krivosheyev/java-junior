package com.acme.edu.message;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.Decorator;

public class BoolMessage extends Message {
    private boolean message;

    public BoolMessage (boolean message, Decorator decorator) {
        super(decorator);
        this.message = message;
    }
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() throws LoggerDecoratorException {

        getDecorator().setMessage(Boolean.toString(message));
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
