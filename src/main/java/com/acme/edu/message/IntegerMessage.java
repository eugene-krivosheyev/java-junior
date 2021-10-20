package com.acme.edu.message;

import com.acme.edu.Decorator;

public class IntegerMessage implements Message {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void accumulate(int value) {
        this.value += value;
    }

    public IntegerMessage(int value) {
        this.value = value;
    }

    public String toString() {
        return new Decorator().decorate(value);
    }
}
