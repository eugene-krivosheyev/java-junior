package com.acme.edu.message;

public class EmptyMessage extends Message {
    public EmptyMessage(){}

    public EmptyMessage(boolean isEnd){
        this();
        this.setEndLogging(isEnd);
    }
    @Override
    public void setMsg(Object message) {}

    @Override
    public void setMsg(Object message, boolean isSum) {}

    @Override
    public Message add(Message msg) {return this;}

    @Override
    public boolean isSameType(Message message) {
        return message instanceof EmptyMessage;
    }

    @Override
    public String toString() {
        return "Empty";
    }

    @Override
    public String prefix() {
        return "";
    }
}
