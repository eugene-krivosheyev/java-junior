package com.acme.edu;

import com.acme.edu.decorators.Decorator;
import com.acme.edu.decorators.ObjectDecorator;

public class ObjectMessage implements Message {
    private Object value;
    private static Decorator decorator = new ObjectDecorator();

    public ObjectMessage(Object message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return decorator.decorate("" + value);
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }
}
