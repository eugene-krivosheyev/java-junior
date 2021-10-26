package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class BooleanMessage implements Message {


    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public String getDecoratedString() {
        return "boolean: " + value;
    }


    @Override
    public boolean isSameType(Message message) {
        return (message instanceof BooleanMessage);
    }

    @Override
    public Message accumulate(Message message) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of Boolean");
        }
        BooleanMessage previousMessage = clone();
        value = ((BooleanMessage)message).value;
        return previousMessage;
    }

    @Override
    public BooleanMessage clone() {
        return new BooleanMessage(value);
    }
}
