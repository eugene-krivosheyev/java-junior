package com.acme.edu.message;

import com.acme.edu.Decorator.IntegerDecorator;
import com.acme.edu.Decorator.PrimitiveDecorator;
import com.acme.edu.Decorator.Decorator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Java_1 on 24.08.2018.
 */

public class IntMessage implements Message {

    private int value;
    private Decorator decorator;
    public static Collection<Integer> arrayOfInt = new ArrayList<>();

    public IntMessage(int message) {
        this.value = message;
        arrayOfInt.add(message);
        decorator = new PrimitiveDecorator();
    }

    public IntMessage(int message, Decorator decorator) {
        this.value = message;
        arrayOfInt.add(message);
        this.decorator = decorator;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String getDecoratedMessage(){
        Integer value = arrayOfInt.stream()
                             .reduce((e1,e2) -> e1 + e2).orElse(null);
        arrayOfInt.clear();
        this.setValue(value);
        return getDecorator().getDecoratedMessage(this);
    }

    @Override
    public void accumulate(Message message){
       // int value = ((IntMessage) message).getValue();
        arrayOfInt.add(((IntMessage) message).getValue());
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