package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class BooleanMessage implements Message {

    private boolean message;
    private static final String PRIMITIVE = "primitive: ";

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return PRIMITIVE + message;
    }

    @Override
    public Message accumulate(Message message){
        return new BooleanMessage(((BooleanMessage) message).getMessage());
    }

    public boolean getMessage() {
        return message;
    }
}