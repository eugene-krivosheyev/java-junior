package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class CharMessage implements Message {
    private char value;
    private static final String CHAR = "char: ";

    public CharMessage(char message) {
        this.value = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return CHAR + value;
    }

    @Override
    public Message accumulate(Message message){
        return new CharMessage(((CharMessage) message).getValue());
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {this.value = value;}
}