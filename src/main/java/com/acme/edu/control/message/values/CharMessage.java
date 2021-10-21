package com.acme.edu.control.message.values;

import com.acme.edu.control.message.Message;

public class CharMessage extends Message {

    private CharMessage(char msg, boolean isSum){
        type = msgType.CHAR;
        setMsg(msg,isSum);
    }

    public CharMessage(char msg){
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
           return String.valueOf((char) data);
        } else {
            return prefix() + (char) data;
        }
    }
}
