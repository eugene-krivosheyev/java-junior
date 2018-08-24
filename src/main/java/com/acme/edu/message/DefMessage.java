package com.acme.edu.message;

public class DefMessage implements Message {

    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof DefMessage;
    }
}
