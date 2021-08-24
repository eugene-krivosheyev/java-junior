package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class StringMessage extends Message{
    private final String body;

    public StringMessage(String body) {
        super(body);

        this.body = body;
    }

    @Override
    public void writeMessageToLog(){
        String result = String.format("%s %s%n", Prefix.STRING.value, body);
        ConsoleSaver.writeToConsole(result);
    }

    public void writeMessageToLog(int counter){
        String result = String.format("%s %s (%d)%n", Prefix.STRING.value, body, counter);
        ConsoleSaver.writeToConsole(result);
    }
}
