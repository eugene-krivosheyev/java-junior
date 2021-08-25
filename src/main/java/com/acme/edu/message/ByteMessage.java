package com.acme.edu.message;

import com.acme.edu.Prefix;

public class ByteMessage extends Message{
    private byte body;

    public ByteMessage(byte body) {
        super(body);

        this.body = body;
    }

    public Message accumulate(ByteMessage message){
        return new ByteMessage((byte) (message.body + this.body));
    }

    @Override
    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
    }
}
