package com.acme.edu.message;

import com.acme.edu.Prefix;

public class IntMessage extends Message {

    public IntMessage(int body) {
        super(body);
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public Message accumulate(Message message) {
        return new IntMessage((int)getBody() + (int) message.getBody());
    }

    @Override
    public String getDecoratedMessage() {
        return getDefaultDecoratedMessage(Prefix.PRIMITIVE);
    }
}
