package com.acme.edu.accumulator;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

public class IntAccumulator {
    private Long accumulator;

    public IntAccumulator(){
        this.accumulator = null;
    }

    public Message addValueToAccumulator(int value){
        accumulator = accumulator == null ? value : accumulator + value;

        Message message = null;

        if (accumulator >= Integer.MAX_VALUE) {
            message = removeIntegerOverflow(Integer.MAX_VALUE);
        } else if (accumulator <= Integer.MIN_VALUE) {
            message = removeIntegerOverflow(Integer.MIN_VALUE);
        }

        return message;
    }

    private Message removeIntegerOverflow(int value) {
        Message message = new IntMessage(value);
        accumulator = accumulator - value == 0 ? null : accumulator - value;

        return message;
    }

    public Message flush(){
        if(accumulator == null){
            return null;
        }
        int returnValue = Math.toIntExact(accumulator);
        this.accumulator = null;

        return new IntMessage(returnValue);
    }
}
