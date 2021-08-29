package com.db.edu.message;

import static com.db.edu.message.Prefix.PRIMITIVE_PREFIX;

public class ByteMessage extends Message {

    private byte byteResult;

    public ByteMessage(byte message) {
        super(message);
        this.byteResult = message;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        if (!sameTypeOf(message)) {
            flush();
            return this;
        }
        byteResult += (byte) message.getMessage();
        return this;
    }

    @Override
    public String decorate() {
        return PRIMITIVE_PREFIX.body + byteResult;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof ByteMessage;
    }

    private void flush() {
        byteResult = 0;
    }
}
