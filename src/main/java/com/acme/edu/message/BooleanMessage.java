package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;
import com.acme.edu.message.Message;

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
