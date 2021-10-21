package com.acme.edu.control.message.arrays;

import com.acme.edu.control.message.Message;

public class StringArrayMessage extends Message {

    public StringArrayMessage(String[] msg, boolean isSum){
        type = msgType.ASTRING;
        setMsg(msg,isSum);
    }

    public StringArrayMessage(String[] msg){
        this(msg,false);
    }

    public StringArrayMessage(StringArrayMessage message) {
        this((String[]) message.getData(), message.isSum());
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
    public Message add(Message msg) {return this;}

    @Override
    public String toString() {
        if (isSumming){
           return sumStringArray(" ");
        } else {
            return prefix() + sumStringArray(sep);
        }
    }

    private String sumStringArray(String separator){
        StringBuilder sumMsg = new StringBuilder("");
        for (String str: (String[]) data ) {
            sumMsg.append(str).append(separator);
        }
        return sumMsg.toString();
    }

}
