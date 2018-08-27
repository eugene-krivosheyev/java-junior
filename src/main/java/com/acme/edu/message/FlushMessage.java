package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class FlushMessage extends Message {
    public FlushMessage(Decorator decorator) {
        super(decorator);
    }

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
