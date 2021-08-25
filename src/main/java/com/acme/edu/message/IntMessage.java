package com.acme.edu.message;

import com.acme.edu.Prefix;

public class IntMessage extends Message{
    private int body;

    public IntMessage(int body) {
        super(body);
        this.body = body;
    }

    public Message accumulate(IntMessage message){
        this.body += message.body;
        return this;
    }

    @Override
    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
    }
}
