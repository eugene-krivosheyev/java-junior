package com.acme.edu.message;

import com.acme.edu.message.decorator.LoggerDecorator;

public class StringMessage extends Message {
    private static final String TYPE_NAME = "string";
    private String value;
    private int currentStringCount;

    private StringMessage(String message, int count) {
        this.value = message;
        type = TYPE_NAME;
        currentStringCount = count;
    }

    public StringMessage(String message){
        this(message, 1);
    }

    public String getValue() {
        return value;
    }

    public int getStringCount() {
        return currentStringCount;
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(value, currentStringCount + 1);
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator){
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message) && ((StringMessage) message).value.equals(value);
    }

}
