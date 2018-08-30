package com.acme.edu.message;

import com.acme.edu.AccumulateException;
import com.acme.edu.DecorateException;

public class ByteMessage implements Message {
    private final String PREFIX = "primitive";
    private final String SEPARATOR = ": ";
    private int accumulatedMessage = 0;
    private String decoratedMessage;

    public ByteMessage(byte rawMessage) {
        this.accumulatedMessage = rawMessage;
        this.decoratedMessage = String.valueOf(rawMessage);
    }

    @Override
    public Message accumulate(Message message) throws AccumulateException {
        try {
            accumulatedMessage += ((ByteMessage) message).accumulatedMessage;
        } catch (Exception e) {
            throw new AccumulateException(e);
        }
        return this;
    }

    @Override
    public Message decorate() throws DecorateException {
        try {
            this.decoratedMessage = PREFIX + SEPARATOR + String.valueOf(accumulatedMessage);
        } catch (Exception e) {
            throw new DecorateException(e);
        }
        return this;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }
}
