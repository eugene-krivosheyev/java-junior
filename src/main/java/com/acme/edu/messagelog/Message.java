package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.AccumulateException;

public abstract class Message<T> {
    protected String type;
    protected T value;

    public Message accumulate(Message message) throws AccumulateException {
        return message;
    }

    public T getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public abstract String getFormattedMessage(LoggerDecorator decorator);

    public boolean canBeAccumulated(Message message) {
        return message.getClass() == this.getClass();
    }
}
