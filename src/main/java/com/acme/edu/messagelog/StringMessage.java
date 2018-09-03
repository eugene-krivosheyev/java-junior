package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.OverflowAccumulationException;
import com.acme.edu.loggerexceptions.StringMessageAccumulationException;

public class StringMessage extends Message<String> {
    private static final String TYPE_NAME = "string";
    private final int currentStringCount;

    private StringMessage(String message, int count) {
        this.value = message;
        type = TYPE_NAME;
        currentStringCount = count;
    }

    public StringMessage(String message){
        this(message, 1);
    }

    public int getStringCount() {
        return currentStringCount;
    }

    @Override
    public Message accumulate(Message message) throws StringMessageAccumulationException {
        if (!((StringMessage) message).value.equals(value)) throw new StringMessageAccumulationException("String value is changed");
        return new StringMessage(value, currentStringCount + 1);
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator){
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message);
    }

}
