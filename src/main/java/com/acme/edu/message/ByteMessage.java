package com.acme.edu.message;

import com.acme.edu.Prefix;

public class ByteMessage extends Message {
    private byte body;

    public ByteMessage(byte body) {
        super(body);

        this.body = body;
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += (byte) message.getBody();
    }

    @Override
    public String getDecoratedMessage() {
        return String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
    }
}
