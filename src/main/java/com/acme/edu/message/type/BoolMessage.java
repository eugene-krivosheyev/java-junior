package com.acme.edu.message.type;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.IllegalMessageExeption;
import com.acme.edu.message.Message;

public class BoolMessage extends DataEqualMessage {

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
    public DataEqualMessage add(Message msg) throws IllegalMessageExeption {
        throw new IllegalMessageExeption("Bool messages impossible to summing");
    }

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
