package com.acme.edu.messages;

public class BooleanMessage implements Message {
    private boolean messageBody;

    public BooleanMessage(boolean message) {
        this.messageBody = message;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public String getBody() {
        String messagePrefix = "primitive: ";
        return messagePrefix + messageBody;
    }

    @Override
    public String flush() {
        return (getBody());
    }

    @Override
    public void init() {
    }
}
