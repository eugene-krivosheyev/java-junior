package com.acme.edu.control.message.values;

import com.acme.edu.control.message.Message;

public class BoolMessage extends Message {

    private BoolMessage(boolean msg, boolean isSum){
        type = msgType.BOOL;
        setMsg(msg,isSum);
    }

    public BoolMessage(boolean msg){
        this(msg,false);
    }
    @Override
    public void setMsg(Object message) {
        data = message;
    }

    @Override
    public void setMsg(Object message, boolean isSum) {
        setMsg(message);
    }

    @Override
    public Message add(Message msg) {return this;}

    @Override
    public String toString() {
        if (isSumming){
           return String.valueOf((boolean) data);
        } else {
            return prefix() + (boolean) data;
        }
    }
}
