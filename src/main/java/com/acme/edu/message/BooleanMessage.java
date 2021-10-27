package com.acme.edu.message;

import com.acme.edu.exception.IllegalMessageStateException;

import java.util.List;

public class BooleanMessage implements Message {

    private static final String BOOLEAN_PREFIX = "primitive: ";

    private boolean accumulator;

    public BooleanMessage(boolean bool) {
        this.accumulator = bool;
    }

    @Override
    public Message[] append(Message message) {
        return new Message[]{ message };
    }

    @Override
    public String getBody() {
        return BOOLEAN_PREFIX + accumulator;
    }

    @Override
    public boolean canAppend(Message message) {
        return false;
    }
}
