package com.acme.edu.messages;

public class CharMessage implements Message {
    private static String messagePrefix = "char: ";
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
        boolean isSameType = message instanceof CharMessage;
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
