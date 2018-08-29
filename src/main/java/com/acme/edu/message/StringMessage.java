package com.acme.edu.message;

public class StringMessage implements Message {
    private final String PREFIX = "string";
    private final String SEPARATOR = ": ";
    //private final String COUNTER_FRAME = "("

    private String rawMessage;
    private String decoratedMessage;
    private int counter;

    public StringMessage(String rawMessage) {
        this.counter = 1;
        this.rawMessage = rawMessage;
        this.decoratedMessage = String.valueOf(rawMessage);
    }

    @Override
    public Message accumulate(Message message) {
        if (((StringMessage)message).rawMessage.equals(rawMessage)) {
            counter ++;
        } else {
            counter = 1;
            rawMessage = ((StringMessage)message).rawMessage;
        }
        return this;
    }

    @Override
    public Message decorate() {
        if (counter > 1) {
            this.decoratedMessage = PREFIX + SEPARATOR + String.valueOf(rawMessage) + " (x" + counter + ")" ;
        } else {
            this.decoratedMessage = PREFIX + SEPARATOR + String.valueOf(rawMessage);
        }

        return this;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }
}
