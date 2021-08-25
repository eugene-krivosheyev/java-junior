package com.acme.edu.message;

import com.acme.edu.Prefix;

public class StringMessage extends Message{
    private final String body;
    private String prevBody;

    private int stringCounter = 1;

    public StringMessage(String body) {
        super(body);

        this.prevBody = body;
//        System.out.println("GetPrevBody: " + this.prevBody);
        this.body = body;
    }

    public StringMessage(String body, int stringCounter) {
        super(body);

        this.body = body;
        this.stringCounter = stringCounter;
    }

    // TODO
    @Override
    public boolean sameTypeOf(Message message) {
        if (message instanceof StringMessage) {
            return true;
        }
        return false;
    }

    @Override
    public StringMessage accumulate(Message message){
        if(body.equals(prevBody)) {
            this.stringCounter++;
        }
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
            stringCounter = 1;
        }

        return result;
    }
}
