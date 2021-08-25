package com.db.edu;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.PRIMITIVE_PREFIX;

public class ByteMessage {
    private byte message;
    private static int byteResult;

    public ByteMessage(byte message) {
        this.message = message;
    }

    Object accumulate(Object type) {
        if (!(type instanceof Byte)) {
            flush();
            type = message;
        }
        byteResult += message;
        return type;
    }

    static void flushByte() {
        while (byteResult > Byte.MAX_VALUE) {
            byteResult -= Byte.MAX_VALUE;
            ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + Byte.MAX_VALUE);
        }
        while (byteResult < Byte.MIN_VALUE) {
            byteResult -= Byte.MIN_VALUE;
            ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + Byte.MIN_VALUE);
        }
        ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + byteResult);
        byteResult = 0;
    }
}
