package com.acme.edu.message.type;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class CharMessage extends DataEqualMessage {

    private CharMessage(char msg, boolean isSum){
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
    public DataEqualMessage add(Message msg) {return this;}

    @Override
    public boolean isSameType(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public String toString() {
        if (isSumming){
           return String.valueOf((char) data);
        } else {
            return prefix() + (char) data;
        }
    }

    @Override
    public String prefix() {
        return "char: ";
    }
}
