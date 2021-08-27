package com.db.edu.message;

import static com.db.edu.message.Prefix.PRIMITIVE_PREFIX;

public class ByteMessage extends Message {

    private byte byteResult;

    public ByteMessage(byte message) {
        super(message);
        byteResult = message;
    }

    @Override
    public void flush() {
//        while (byteResult > Byte.MAX_VALUE) {
//            byteResult -= Byte.MAX_VALUE;
//            saver.save(decorate(String.valueOf(Byte.MAX_VALUE)));
//        }
//        while (byteResult < Byte.MIN_VALUE) {
//            byteResult -= Byte.MIN_VALUE;
//            saver.save(decorate(String.valueOf(Byte.MIN_VALUE)));
//        }
        saver.save(decorate(String.valueOf(byteResult)));
        byteResult = 0;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        if (!sameTypeOf(message)) {
            flush();
            return this;
        }
        byteResult += (byte)message.getMessage();
        return this;
    }

    @Override
    public String decorate(Object message) {
        return PRIMITIVE_PREFIX.body + message;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof ByteMessage;
    }
}
