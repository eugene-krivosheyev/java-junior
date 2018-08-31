package com.acme.edu.messagelog;

public class CharMessage extends Message<Character> {
    private static final String TYPE_NAME = "char";

    public CharMessage(char message) {
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
