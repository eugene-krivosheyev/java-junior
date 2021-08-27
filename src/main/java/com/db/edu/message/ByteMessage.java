package com.db.edu.message;

import com.db.edu.Types;

public class ByteMessage {
    private final byte body;

    public ByteMessage(byte message) {
        this.body = message;
    }

    public String getDecoratedMessage() {
        return Types.PREFIX_PRIMITIVE + ": " + body;
    }
}