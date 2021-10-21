package com.acme.edu.message.type;

import com.acme.edu.message.Message;

public class BoolMessage extends Message {

    private BoolMessage(boolean msg, boolean isSum){
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
    public boolean isSameType(Message message) {
        return message instanceof BoolMessage;
    }

    @Override
    public String toString() {
        if (isSumming){
           return String.valueOf((boolean) data);
        } else {
            return prefix() + (boolean) data;
        }
    }

    @Override
    public String prefix() {
        return "primitive: ";
    }
}
