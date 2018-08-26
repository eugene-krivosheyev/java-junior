package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */

public class IntMessage implements Message {

    private int value;
    public static final String PRIMITIVE = "primitive: ";

    public IntMessage(int message) {
        this.value = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return PRIMITIVE + value;
    }

    @Override
    public Message accumulate(Message message){
        int value = ((IntMessage) message).getValue();
        return new IntMessage(value + this.value);
    }

    public int getValue() {
        return value;
    }
}