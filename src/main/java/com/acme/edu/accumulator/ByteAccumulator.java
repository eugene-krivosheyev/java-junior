package com.acme.edu.accumulator;

import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.Message;

public class ByteAccumulator {
    private Long accumulator;

    public ByteAccumulator(){
        this.accumulator = null;
    }

    public Message addValueToAccumulator(byte value){
        accumulator = accumulator == null ? value : accumulator + value;

        Message message = null;

        if (accumulator >= Byte.MAX_VALUE) {
            message = removeIntegerOverflow(Byte.MAX_VALUE);
        } else if (accumulator <= Byte.MIN_VALUE) {
            message = removeIntegerOverflow(Byte.MIN_VALUE);
        }

        return message;
    }

    private Message removeIntegerOverflow(byte value) {
        Message message = new ByteMessage(value);
        accumulator = accumulator - value == 0 ? null : accumulator - value;

        return message;
    }

    public Message flush(){
        if(accumulator == null){
            return null;
        }
        byte returnValue = (byte) Math.toIntExact(accumulator);
        this.accumulator = null;

        return new ByteMessage(returnValue);
    }
}
