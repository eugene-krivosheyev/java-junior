package com.acme.edu;

import com.acme.edu.decorators.CharDecorator;
import com.acme.edu.decorators.Decorator;

public class CharMessage implements Message {
    private char value;
    private Decorator decorator;

    public CharMessage(char value, Decorator decorator) {
        this.value = value;
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
