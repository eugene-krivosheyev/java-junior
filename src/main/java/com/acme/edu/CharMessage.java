package com.acme.edu;

import com.acme.edu.decorators.CharDecorator;
import com.acme.edu.decorators.Decorator;

public class CharMessage implements Message {
    private char value;
    private static Decorator decorator = new CharDecorator();


    public CharMessage(char message) {
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
