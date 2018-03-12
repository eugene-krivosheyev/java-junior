package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.MessageController;
import com.acme.edu.formatters.PrefixFormatter;

public class ByteMessage implements Message {

    private byte message;
    private static byte byteBuffer;
    private static final String byteUsage = "ByteMessage";

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public String  isUsed() {
        return byteUsage;
    }

    @Override
    public void accumulate() {
        int sum = byteBuffer+(int)message;
        if ((sum)<=Byte.MAX_VALUE && (sum)>=Byte.MIN_VALUE){
            byteBuffer +=message;
        }else{
            if ((sum)>Byte.MAX_VALUE){
                sum=sum-Byte.MAX_VALUE;
                Flusher.setUsed(byteUsage);
                Flusher.setValue(String.valueOf(Byte.MAX_VALUE));
                Flusher.flush();
                byteBuffer = (byte) sum;
            } else{
                if((sum)<Byte.MIN_VALUE){
                    sum=sum-Byte.MIN_VALUE;
                    Flusher.setUsed(byteUsage);
                    Flusher.setValue(String.valueOf(Byte.MIN_VALUE));
                    Flusher.flush();
                    byteBuffer = (byte) sum;
                }
            }
        }
        Flusher.setUsed(byteUsage);
        Flusher.setValue(String.valueOf(byteBuffer));
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
        byteBuffer = (byte) 0;
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitByteMessage(this);
    }
}
