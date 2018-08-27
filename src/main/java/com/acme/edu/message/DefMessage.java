package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class DefMessage extends Message {

    public DefMessage(Decorator decorator) {
        super(decorator);
    }

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
