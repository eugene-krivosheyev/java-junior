package com.acme.edu.control.message.values;

import com.acme.edu.control.message.Message;

public class StringMessage extends Message {

    private int counter = 1;

    public StringMessage(String msg, boolean isSum){
        type = msgType.STRING;
        setMsg(msg,isSum);
    }

    public StringMessage(String msg){
        this(msg,false);
    }

    public StringMessage(StringMessage message) {
        this((String) message.getData(), message.isSum());
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
            if (isSame(msg)){
                counter++;
                setEndLogging(false);
            } else {
                counter = 1;
                setEndLogging(false);
                Message tempMsg = new StringMessage(this);
                data = msg.getData();
                return tempMsg;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        if (isSumming){
           return sumString();
        } else {
            return prefix() + data;
        }
    }

    @Override
    public boolean isMAXMIN(Message message){
        return !isSame(message); //|| (MIN - bufferInteger > value);
    }

    private String sumString(){
        if (counter != 1) {return String.format("%s (x%d)", (String)data,counter);}
        return (String) data;
    }

}
