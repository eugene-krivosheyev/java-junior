package com.acme.edu.processors;

import com.acme.edu.messageOut.Printer;

public class ObjectMessage implements Message{

    private static String messagePrefix = "reference: ";
    private Object messageValue;

    public ObjectMessage(Object message){
        this.messageValue = message;
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
