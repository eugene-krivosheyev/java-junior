package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class CharMessage implements Message {
    private char message;
    private static final String CHAR = "char: ";

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return CHAR + message;
    }

    @Override
    public Message accumulate(Message message){
        return new CharMessage(((CharMessage) message).getMessage());
    }

    public char getMessage() {
        return message;
    }
}