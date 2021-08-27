package com.acme.edu.message;

import com.acme.edu.Prefix;

public class CharMessage extends Message {
    private final char body;

    public CharMessage(char body) {
        super(body);
        this.body = body;
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return false;
    }

    @Override
    public void accumulate(Message message) {

    }

    @Override
    public String getDecoratedMessage() {
        return String.format("%s %s%n", Prefix.CHAR.value, body);
    }
}
