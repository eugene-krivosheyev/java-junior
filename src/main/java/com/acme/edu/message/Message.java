package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class Message {
    private Object body;

    public Message(Object body) {
        this.body = body;
    }

    public String getDecoratedMessage(){
        return String.format("%s %s%n", Prefix.REFERENCE.value, body.toString());
    }
}
