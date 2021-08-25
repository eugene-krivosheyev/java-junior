package com.acme.edu.message;

import com.acme.edu.Prefix;

import java.util.Objects;

public class StringMessage extends Message{
    private String body;
    private int stringCounter;

    public StringMessage(String body) {
        super(body);

        this.body = body;
        this.stringCounter = 1;
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
    public boolean sameTypeOf(Message message) {
        return message instanceof StringMessage && Objects.equals(message.getBody(), this.getBody());
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
