package com.acme.edu.messages;

import com.acme.edu.Printer;

public class BooleanMessage implements Message {

    private static String messagePrefix = "primitive: ";
    private boolean messageValue;

    public BooleanMessage(boolean message){
        this.messageValue = message;
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
