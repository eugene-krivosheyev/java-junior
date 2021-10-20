package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class ByteMessage implements Message {
    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    private byte value;

    public ByteMessage(byte message) {
        value = message;
    }
    @Override
    public String getDecoratedString() {
        return "primitive: " + value;
    }

    @Override
    public void clear() {
        value = 0;
    }
}
