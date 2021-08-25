package com.acme.edu.accumulator;

import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;

import java.util.Objects;

public class StringAccumulator {
    private String prevString;
    private int stringCounter;

    public StringAccumulator(){
        this.prevString = null;
        this.stringCounter = 0;
    }

    public Message accumulateString(String text){
        Message message = null;
        if (Objects.equals(text, prevString)) {
            stringCounter++;
        } else {
            if (stringCounter != 0) {
                message = flush();
            }

            stringCounter = 1;
            prevString = text;
        }

        return message;
    }

    public Message flush(){
        Message message = null;

        if (prevString != null) {
            if (stringCounter == 1) {
                message = new StringMessage(prevString);
            } else {
                message = new StringMessage(prevString, stringCounter);
            }

            prevString = null;
            stringCounter = 0;
        }

        return message;
    }
}
