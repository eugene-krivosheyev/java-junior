package com.acme.edu.messages;

public class CharMessage implements Message {
    private char messageBody;

    public CharMessage(char message) {
        this.messageBody = message;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public String getBody() {
        String messagePrefix = "char: ";
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
