package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;
import com.acme.edu.message.Message;

public class ObjectMessage implements Message {
    private Object value;
    private Decorator decorator;

    public ObjectMessage(Object value, Decorator decorator) {
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
