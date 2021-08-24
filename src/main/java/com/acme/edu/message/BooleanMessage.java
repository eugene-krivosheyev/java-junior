package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class BooleanMessage extends Message{
    private final boolean body;

    public BooleanMessage(boolean body) {
        super(body);
        this.body = body;
    }

    @Override
    public void writeMessageToLog(){
        String result = String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
        ConsoleSaver.writeToConsole(result);
    }
}
