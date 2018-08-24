package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class IntMessage implements Message {

    private int message;
    private int sum = 0;
    public static final String PRIMITIVE = "primitive: ";

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return PRIMITIVE + message;
    }

    @Override
    public Message accumulate(Message message){
        int value = ((IntMessage) message).getMessage();
        sum = sum + value;
        return new IntMessage(sum);
    }

    public int getMessage() {
        return message;
    }
}