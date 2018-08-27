package com.acme.edu;

import com.acme.edu.decorators.BooleanDecorator1;
import com.acme.edu.decorators.BooleanDecorator2;
import com.acme.edu.decorators.Decorator;

public class BooleanMessage implements Message {
    private boolean value;
    private static Decorator decorator = new BooleanDecorator2();

    public BooleanMessage(boolean message) {
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
