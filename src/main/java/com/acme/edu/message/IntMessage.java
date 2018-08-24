package com.acme.edu.message;

public class IntMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive";
    private final String SEPARATOR = ": ";

    private int accumulatedMessage = 0;
    private String decoratedMessage;

    public IntMessage(int rawMessage) {
        this.accumulatedMessage = rawMessage;
        this.decoratedMessage = String.valueOf(rawMessage);
    }

    @Override
    public Message accumulate(Message message) {
        accumulatedMessage += ((IntMessage)message).accumulatedMessage;
        return this;
    }

    @Override
    public Message decorate() {
        this.decoratedMessage = PRIMITIVE_PREFIX + SEPARATOR + String.valueOf(accumulatedMessage);
        return this;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }
//
//    public String getDecoratedMessage() {
//        return decoratedMessage;
//    }
//
//    public int getRawMessage() {
//        return rawMessage;
//    }
}
