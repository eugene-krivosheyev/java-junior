package com.acme.edu.messages;

import java.util.Objects;

public class StringMessage implements Message {
    private int stringCounter = 1;
    private String messageBody;

    public StringMessage(String message) {
        this.messageBody = message;
    }

    public StringMessage(String message,int stringCounter) {
        this.messageBody = message;
        this.stringCounter = stringCounter;
    }

    @Override
    public Message accumulate(Message message) {
        if(! (message instanceof StringMessage)) throw new IllegalArgumentException("Another type of message!");
        if (Objects.equals(messageBody, ((StringMessage) message).messageBody)) {
  //          ((StringMessage) message).stringCounter = stringCounter +1;
            return new StringMessage(((StringMessage) message).messageBody, stringCounter+1);
        } else {
            System.out.println(flush());
            return message;
        }
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public String getBody() {
        String messagePrefix = "string: ";
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
        stringCounter = 1;
    }

}
