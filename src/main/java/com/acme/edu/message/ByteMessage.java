package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class ByteMessage extends Message{
    private final byte message;

    public ByteMessage(byte message) {
        typeCodeEnum = TypeCodeEnum.BYTE;
        this.message = message;
    }

    public byte getMessage() {
        return message;
    }
}
