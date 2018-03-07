package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.MessageController;

public class ByteMessage implements Message {

    private byte message;
    private static byte byteBuffer;
    private static boolean byteUsage;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public static byte getByteBuffer() {
        return byteBuffer;
    }

    @Override
    public boolean isUsed() {
        return byteUsage;
    }

    @Override
    public void accumulate() {
        if ((byteBuffer+message)<=Byte.MAX_VALUE && (byteBuffer+message)>=Byte.MIN_VALUE){
            byteBuffer +=message;
        }else if ((byteBuffer+message)>Byte.MAX_VALUE){
            long overBuffer = byteBuffer+message;
            overBuffer=overBuffer-Byte.MAX_VALUE;
            byte needToFlush = Byte.MAX_VALUE;
            MessageController.overFlush(needToFlush);
            byteBuffer = (byte) overBuffer;
        } else if((byteBuffer+message)<Byte.MIN_VALUE){
            long overBuffer = byteBuffer+message;
            overBuffer=overBuffer-Byte.MIN_VALUE;
            byte needToFlush = Byte.MIN_VALUE;
            MessageController.overFlush(needToFlush);
            byteBuffer = (byte) overBuffer;
        }
        byteUsage = true;

        Flusher.setBuffer(byteBuffer);
        Flusher.setUsage(byteUsage);
    }
    @Override
    public void flush(){
        byteBuffer = (byte) 0;
        byteUsage = false;
    }
}
