package com.acme.edu.messagelog;

public class BooleanMessage extends Message<Boolean> {
    private static final String TYPE_NAME = "primitive";

    public BooleanMessage(boolean message) {
        this.value = message;
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
