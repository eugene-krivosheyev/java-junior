package com.acme.edu.message;

import com.acme.edu.Prefix;

public class IntMessage extends Message {
    private int body;

    public IntMessage(int body) {
        super(body);
        this.body = body;
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += (int) message.getBody();
    }

    @Override
    public String getDecoratedMessage() {
        return String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
    }
}
