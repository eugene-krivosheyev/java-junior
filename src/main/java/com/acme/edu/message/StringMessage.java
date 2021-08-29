package com.acme.edu.message;

import com.acme.edu.Prefix;

import java.util.Objects;

public class StringMessage extends Message {

    private int stringCounter = 1;

    public StringMessage(String body) {
        super(body);
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof StringMessage && Objects.equals(message.getBody(), getBody());
    }

    @Override
    public Message accumulate(Message message) {
        if (getBody().equals(message.getBody())) {
            this.stringCounter++;
        }
        return this;
    }

    @Override
    public String getDecoratedMessage() {
        String result;
        if (stringCounter == 1) {
            result = getDefaultDecoratedMessage(Prefix.STRING);
        } else {
            result = String.format("%s %s (x%d)%n", Prefix.STRING.value, getBody(), stringCounter);
        }
        return result;
    }
}
