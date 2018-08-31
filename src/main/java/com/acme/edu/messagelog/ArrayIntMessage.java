package com.acme.edu.messagelog;

public class ArrayIntMessage extends Message<int[]> {
    private static final String TYPE_NAME = "primitives array";

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
}
