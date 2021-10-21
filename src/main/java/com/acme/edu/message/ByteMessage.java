package com.acme.edu.message;

import com.acme.edu.Decorator;

public class ByteMessage implements Message {
    private byte value;

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public void accumulate(byte value) {
        this.value += value;
    }

    public ByteMessage(byte value) {
        this.value = value;
    }

    public String toString() {
        return new Decorator().decorate(value);
    }
}
