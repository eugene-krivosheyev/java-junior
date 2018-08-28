package com.acme.edu.message;

public abstract class Message {
    protected String type;

    public Message accumulate(Message message){
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
