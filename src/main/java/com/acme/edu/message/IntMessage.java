package com.acme.edu.message;

import com.acme.edu.Decorator.IntegerDecorator;
import com.acme.edu.Decorator.PrimitiveDecorator;
import com.acme.edu.Decorator.Decorator;

/**
 * Created by Java_1 on 24.08.2018.
 */

public class IntMessage implements Message {

    private int value;
    private Decorator decorator;

    public IntMessage(int message) {
        this.value = message;
        decorator = new PrimitiveDecorator();
    }

    public IntMessage(int message, Decorator decorator) {
        this.value = message;
        this.decorator = decorator;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return getDecorator().getDecoratedMessage(new IntMessage(getValue()));
    }

    @Override
    public Message accumulate(Message message){
        int value = ((IntMessage) message).getValue();
        return new IntMessage(value + this.value);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setDecorator(Decorator decorator){
        this.decorator = decorator;
    }

    public Decorator getDecorator() {return decorator;}
}