package com.db.edu.message;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class ByteMessage extends Message<Byte> {
    private static int byteResult;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public static void flushByte() {
        while (byteResult > Byte.MAX_VALUE) {
            byteResult -= Byte.MAX_VALUE;
            saver.save(PRIMITIVE_PREFIX.getMessage() + Byte.MAX_VALUE);
        }
        while (byteResult < Byte.MIN_VALUE) {
            byteResult -= Byte.MIN_VALUE;
            saver.save(PRIMITIVE_PREFIX.getMessage() + Byte.MIN_VALUE);
        }
        saver.save(PRIMITIVE_PREFIX.getMessage() + byteResult);
        byteResult = 0;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        if (!(message instanceof IntMessage)) {
            flush();
        }
        byteResult += (int)message.getMessage();
        return this;
    }
}
