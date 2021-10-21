package com.acme.edu.control.message.values;

import com.acme.edu.control.message.Message;

public class ObjectMessage extends Message {

    private ObjectMessage(Object msg, boolean isSum){
        type = msgType.OBJECT;
        setMsg(msg,isSum);
    }

    public ObjectMessage(Object msg){
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
        return prefix() + data;
    }
}
