package com.acme.edu.message;

public class FlushMessage implements Message {
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return "";
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
