package com.db.edu.message;

import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class ByteMessage extends Message {

    private final byte message;
    private byte byteResult;

    public ByteMessage(byte message) {
        super(message);
        this.message = message;
    }

    @Override
    public void flush() {
        while (byteResult > Byte.MAX_VALUE) {
            byteResult -= Byte.MAX_VALUE;
            saver.save(PRIMITIVE_PREFIX.body + Byte.MAX_VALUE);
        }
        while (byteResult < Byte.MIN_VALUE) {
            byteResult -= Byte.MIN_VALUE;
            saver.save(PRIMITIVE_PREFIX.body + Byte.MIN_VALUE);
        }
        saver.save(PRIMITIVE_PREFIX.body + byteResult);
        byteResult = 0;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        if (!(message instanceof IntMessage)) {
            flush();
        }
        byteResult += (byte)message.getMessage();
        return this;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof ByteMessage;
    }
}
