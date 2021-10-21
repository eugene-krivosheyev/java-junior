package com.acme.edu.control.message;

public class EmptyMessage extends Message {
    public EmptyMessage(){
        type = msgType.EMPTY;
    }

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
    public String toString() {
        return "Empty";
    }
}
