package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.AccumulateException;

public abstract class Message {
    protected String type;

    public Message accumulate(Message message) throws AccumulateException {
        return message;
    }

    public String getType() {
        return type;
    }

    public abstract String getFormattedMessage(LoggerDecorator decorator);

    public boolean canBeAccumulated(Message message) {
        return message.getClass() == this.getClass();
    }
}
