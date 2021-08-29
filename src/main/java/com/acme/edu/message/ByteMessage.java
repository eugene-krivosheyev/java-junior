package com.acme.edu.message;

import com.acme.edu.Prefix;

public class ByteMessage extends Message {

    public ByteMessage(byte body) {
        super(body);
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public Message accumulate(Message message) {
        return new ByteMessage((byte) ((byte)getBody() + (byte) message.getBody()));
    }

    @Override
    public String getDecoratedMessage() {
        return getDefaultDecoratedMessage(Prefix.PRIMITIVE);
    }
}
