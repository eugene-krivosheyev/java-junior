package com.acme.edu.message.type;

import com.acme.edu.message.Message;

public class ObjectMessage extends Message {

    private ObjectMessage(Object msg, boolean isSum){
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
    public boolean isSameType(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public String toString() {
        return prefix() + data;
    }

    @Override
    public String prefix() {
        return "reference: ";
    }
}
