package com.acme.edu.message;

import com.acme.edu.Prefix;

public class StringMessage extends Message{
    private String body;
    private int stringCounter;

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
    public StringMessage accumulate(Message message){
        this.stringCounter++;
        return this;
    }

    public String getBody(){
        return this.body;
    }

    @Override
    public String getDecoratedMessage(){
        String result;
        if(stringCounter == 1){
            result = String.format("%s %s%n", Prefix.STRING.value, body);
        }else{
            result = String.format("%s %s (x%d)%n", Prefix.STRING.value, body, stringCounter);
        }

        return result;
    }
}
