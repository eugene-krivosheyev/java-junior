package com.acme.edu;

import com.acme.edu.decorators.BooleanDecorator1;
import com.acme.edu.decorators.BooleanDecorator2;
import com.acme.edu.decorators.Decorator;

public class BooleanMessage implements Message {
    private boolean value;
    private Decorator decorator;

    public BooleanMessage(boolean message, Decorator decorator) {
        this.value = message;
        this.decorator = decorator;
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
