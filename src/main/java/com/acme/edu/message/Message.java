package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class Message {
    private final Object body;

    public Message(Object body) {
        this.body = body;
    }

    public void writeMessageToLog(){
        String result = String.format("%s %s%n", Prefix.REFERENCE.value, body.toString());
        ConsoleSaver.writeToConsole(result);
    }
}
