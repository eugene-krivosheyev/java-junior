package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

public class FlushMessage extends Message {
    public FlushMessage(Decorator decorator){
        super(decorator);
    }

    @Override
    public Message log(Message message) {
        return null;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void accumulate(Message message) {

    }

    @Override
    public String fetch() {
        return "";
    }
}
