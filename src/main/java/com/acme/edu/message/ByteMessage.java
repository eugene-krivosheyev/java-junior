package com.acme.edu.message;

public class ByteMessage implements Message {
    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public Message decorate() {
        return null;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return false;
    }

    @Override
    public String getDecoratedString() {
        return null;
    }
}
