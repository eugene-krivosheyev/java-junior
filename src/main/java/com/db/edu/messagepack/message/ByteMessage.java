package com.db.edu.messagepack.message;

public class ByteMessage extends Message {
    private static final String PREFIX_PRIMITIVE = "primitive";
    private final byte body;

    public ByteMessage(byte message) {
        this.body = message;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX_PRIMITIVE + ": " + body;
    }


}