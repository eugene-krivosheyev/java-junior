package com.acme.edu.messages;

public class ObjectMessage implements Message {
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
        return message instanceof ObjectMessage;
    }

    @Override
    public String getBody() {
        String messagePrefix = "reference: ";
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
