package com.db.edu.messagepack.message;

abstract public class Message {
    public abstract String getDecoratedMessage();
    public void resetFields() {};

    public Message accumulate(Message message){
        return message;
    };

    public boolean isSameType(Message message) {
        return false;
    };
}