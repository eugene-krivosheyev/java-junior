package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class BooleanMessage implements Message {

    private boolean value;
    private static final String PRIMITIVE = "primitive: ";

    public BooleanMessage(boolean message) {
        this.value = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return PRIMITIVE + value;
    }

    @Override
    public void accumulate(Message message){}

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {this.value = value;}
}