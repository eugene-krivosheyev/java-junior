package com.acme.edu.message;

import com.acme.edu.message.decorator.LoggerDecorator;

public class ObjectMessage extends Message {
    private static final String TYPE_NAME = "reference";
    private Object value;

    public ObjectMessage(Object message) {
        this.value = message;
        type = TYPE_NAME;
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return  decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return false;
    }

    public Object getValue() {
        return value;
    }
}
