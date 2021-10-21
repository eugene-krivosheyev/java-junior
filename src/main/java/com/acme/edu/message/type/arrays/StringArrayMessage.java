package com.acme.edu.message.type.arrays;

import com.acme.edu.message.Message;

public class StringArrayMessage extends Message {

    public StringArrayMessage(String[] msg, boolean isSum){
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
    public boolean isSameType(Message message) {
        return message instanceof StringArrayMessage;
    }

    @Override
    public String toString() {
        if (isSumming){
           return sumStringArray(" ");
        } else {
            return prefix() + sumStringArray(SEP);
        }
    }

    @Override
    public String prefix() {
        return "";
    }

    private String sumStringArray(String separator){
        StringBuilder sumMsg = new StringBuilder("");
        for (String str: (String[]) data ) {
            sumMsg.append(str).append(separator);
        }
        return sumMsg.toString();
    }

}
