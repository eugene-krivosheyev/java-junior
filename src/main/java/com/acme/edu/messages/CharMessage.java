package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class CharMessage implements Message {
    private char value;

    public CharMessage(char value) {
        this.value = value;
    }

    @Override
    public String getDecoratedString() {
        return "char: " + value;
    }

    @Override
    public boolean isSameType(Message message) {
        return (message instanceof CharMessage);
    }

    @Override
    public Message accumulate(Message message) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of CharMessage");
        }
        return this;
    }
}
