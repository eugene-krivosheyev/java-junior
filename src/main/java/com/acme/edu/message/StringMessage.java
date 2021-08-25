package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class StringMessage extends Message{
    private final String body;
    private final int stringCounter;

    public StringMessage(String body) {
        super(body);

        this.body = body;
        this.stringCounter = 1;
    }

    public StringMessage(String body, int stringCounter) {
        super(body);

        this.body = body;
        this.stringCounter = stringCounter;
    }

    @Override
    public void writeMessageToLog(){
        String result;
        if(stringCounter == 1){
            result = String.format("%s %s%n", Prefix.STRING.value, body);
        }else{
            result = String.format("%s %s (x%d)%n", Prefix.STRING.value, body, stringCounter);
        }

        ConsoleSaver.writeToConsole(result);
    }
}
