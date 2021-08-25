package com.acme.edu.message;

import com.acme.edu.Prefix;

public class Message {
    private Object body;

    public Message(Object body) {
        this.body = body;
    }

    public Object getBody(){
        return this.body;
    }

    public boolean sameTypeOf(Message message){
        return false;
    }

    public Message accumulate(Message message) {
        return this;
    }

    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.REFERENCE.value, body.toString());
    }
}
