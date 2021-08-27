package com.acme.edu.message;

import com.acme.edu.Prefix;

public class BooleanMessage extends Message{
    private final boolean body;

    public BooleanMessage(boolean body) {
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
    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
    }
}
