package com.acme.edu.messages;

import java.util.Objects;

public class StringMessage implements Message {
    private static String bufferString;
    private static int stringCounter;
    private static String messagePrefix = "string: ";
    private String messageBody;

    public StringMessage(String message) {
        this.messageBody = message;
    }

    @Override
    public Message accumulate(Message message) {
        if (Objects.equals(messageBody, ((StringMessage) message).messageBody)) {
            stringCounter += 1;

        } else {
            System.out.println(flush());

        }
        return message;
    }

    @Override
    public boolean isSameType(Message message) {
        boolean isSameType = message instanceof StringMessage;
        return isSameType;
    }

    @Override
    public String getBody() {
        return messagePrefix + messageBody;
    }

    @Override
    public String flush() {
        String OutString = (stringCounter == 1 ? getBody() : getBody() + " (x" + stringCounter + ")");
        stringCounter = 1;
        return OutString;
    }

    @Override
    public void init() {
        bufferString = messageBody;
        stringCounter = 1;
    }

}
