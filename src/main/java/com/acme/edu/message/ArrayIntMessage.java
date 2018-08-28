package com.acme.edu.message;

import com.acme.edu.decorator.LoggerDecorator;

public class ArrayIntMessage extends Message {
    private static final String TYPE_NAME = "primitives array";
    private final int[] value;

    public ArrayIntMessage(int ... message) {
        this.value = message.clone();
        type = TYPE_NAME;
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return false;
    }

    public int[] getValue() {
        return value.clone();
    }
}
