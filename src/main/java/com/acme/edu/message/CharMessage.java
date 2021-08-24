package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class CharMessage extends Message{
    private final char body;

    public CharMessage(char body) {
        super(body);
        this.body = body;
    }

    @Override
    public void writeMessageToLog(){
        String result = String.format("%s %s%n", Prefix.CHAR.value, body);
        ConsoleSaver.writeToConsole(result);
    }
}
