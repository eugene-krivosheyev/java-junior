package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;
import com.acme.edu.message.Message;

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
