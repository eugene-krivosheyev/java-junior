package com.acme.edu.message;

import com.acme.edu.Prefix;

import java.util.Objects;

public class StringMessage extends Message {
    private final String body;
    private final String prevBody;

    private int stringCounter = 1;

    public StringMessage(String body) {
        super(body);

        this.prevBody = body;
        this.body = body;
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof StringMessage && Objects.equals(message.getBody(), this.getBody());
    }

    @Override
    public void accumulate(Message message) {
        if (body.equals(prevBody)) {
            this.stringCounter++;
        }
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public String getDecoratedMessage() {
        String result;
        if (stringCounter == 1) {
            result = String.format("%s %s%n", Prefix.STRING.value, body);
        } else {
            result = String.format("%s %s (x%d)%n", Prefix.STRING.value, body, stringCounter);
        }
        return result;
    }
}
