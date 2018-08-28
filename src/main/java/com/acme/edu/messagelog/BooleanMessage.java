package com.acme.edu.messagelog;

public class BooleanMessage extends Message {
    private static final String TYPE_NAME = "primitive";
    private final boolean value;

    public BooleanMessage(boolean message) {
        this.value = message;
        type = TYPE_NAME;
    }

    public boolean getValue() {
        return value;
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
