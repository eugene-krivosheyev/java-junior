package com.acme.edu.message;

import com.acme.edu.Prefix;

public class ByteMessage extends Message{
    private byte body;

    public ByteMessage(byte body) {
        super(body);

        this.body = body;
    }

    @Override
    public Message accumulate(Message message){
        this.body += (byte) message.getBody();
        return this;
    }

    @Override
    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
    }
}
