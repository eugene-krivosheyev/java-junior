package com.acme.edu.messagelog;

public class ObjectMessage extends Message<Object> {
    private static final String TYPE_NAME = "reference";

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
}
