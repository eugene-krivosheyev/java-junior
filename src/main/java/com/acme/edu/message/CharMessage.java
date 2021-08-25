package com.acme.edu.message;

import com.acme.edu.Prefix;

public class CharMessage extends Message{
    private char body;

    public CharMessage(char body) {
        super(body);
        this.body = body;
    }

    @Override
    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.CHAR.value, body);
    }
}
