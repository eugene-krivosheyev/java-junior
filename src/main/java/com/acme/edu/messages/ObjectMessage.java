package com.acme.edu.messages;

public class ObjectMessage implements Message {
    private static String messagePrefix = "reference: ";
    private Object messageBody;

    public ObjectMessage(Object message) {
        this.messageBody = message;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean isSameType(Message message) {
        boolean isSameType = message instanceof ObjectMessage;
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
