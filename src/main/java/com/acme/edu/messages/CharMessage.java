package com.acme.edu.messages;

import com.acme.edu.Printer;

public class CharMessage implements Message {

    private static String messagePrefix = "char: ";
    private char messageValue;

    public CharMessage(char message) {
        this.messageValue = message;
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
        return messagePrefix + messageValue;
    }

    @Override
    public void flush() {
        Printer.print(getBody());
    }

    @Override
    public void init() {
    }
}
