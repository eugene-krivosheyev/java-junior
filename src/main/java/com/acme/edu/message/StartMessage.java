package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.saver.Saver;

public class StartMessage extends Message {
    public StartMessage(Saver saver, Decorator decorator) {
        super(saver, decorator);
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
        return null;
    }
}
