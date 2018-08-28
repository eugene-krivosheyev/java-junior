package com.acme.edu.messagelog;

public class CharMessage extends Message {
    private static final String TYPE_NAME = "char";
    private final char value;

    public CharMessage(char message) {
        this.value = message;
        type = TYPE_NAME;
    }

    public char getValue() {
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
