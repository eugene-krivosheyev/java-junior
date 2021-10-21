package com.acme.edu.message.type;

import com.acme.edu.message.Message;

public class IntMessage extends Message {
    static final int MAXVALUE = Integer.MAX_VALUE;
    static final int MINVALUE = Integer.MIN_VALUE;

    public IntMessage(int msg, boolean isSum){
        setMsg(msg,isSum);
    }
    public IntMessage(int msg){
        this(msg,false);
    }

    public IntMessage(IntMessage message){
        this((int) message.getData(), message.isSum());
    }
    @Override
    public void setMsg(Object message) {
        data = message;
    }

    @Override
    public void setMsg(Object message, boolean isSum) {
        setMsg(message);
        isSumming = isSum;
    }

    @Override
    public Message add(Message msg) {
        if (isSameType(msg)){
            if (!isMAXMIN(msg)){
                data = ((int)data + (int)msg.getData());
                setEndLogging(false);
                return this;
            } else {
                Message tempMsg = new IntMessage(this);
                data = (isMAX(msg))?MAXVALUE:data;
                data = (isMIN(msg))?MINVALUE:data;
                setEndLogging(true);
                return tempMsg;
            }
        }
        setEndLogging(false);
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String toString() {
        if (isSumming){
           return String.valueOf(((int) data));
        } else {
            return prefix() + (int) data;
        }
    }

    @Override
    public boolean isMAXMIN(Message value){
        return isMAX(value); //|| (MIN - bufferInteger > value);
    }

    @Override
    public boolean isMAX(Message value) {
        return (MAXVALUE - (int)data < (int)value.getData());
    }

    @Override
    public boolean isMIN(Message value) {
        return super.isMIN(value);
    }

    @Override
    public String prefix() {
        return "primitive: ";
    }
}
