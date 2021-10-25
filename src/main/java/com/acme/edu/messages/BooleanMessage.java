package com.acme.edu.messages;

public class BooleanMessage implements Message {
    private static String messagePrefix = "primitive: ";
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
        boolean isSameType = message instanceof BooleanMessage;
        return isSameType;
    }

    @Override
    public String getBody() {
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
