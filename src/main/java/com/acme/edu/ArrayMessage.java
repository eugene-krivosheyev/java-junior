package com.acme.edu;

import com.acme.edu.decorators.ArrayDecorator;
import com.acme.edu.decorators.Decorator;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class ArrayMessage implements Message {
    private int[] value;
    private Decorator decorator;

    public ArrayMessage(int[] value, Decorator decorator) {
        this.value = value;
        this.decorator = decorator;
    }

    @Override
    public String decorate() {
        String[] valuesInStrings = new String[value.length];
        for (int i = 0; i < value.length; i++) {
            valuesInStrings[i] = "" + value[i];
            //System.out.println();
        }
        return decorator.decorate(valuesInStrings);
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }
}
