package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.saver.Saver;

public class BoolMessage extends Message {
    private boolean message;
    //  int sum = 0;
    public BoolMessage (boolean message, Saver saver, Decorator decorator) {
        super(saver, decorator);
        this.message = message;
    }
    @Override
    public Message log(Message message) {
        return null;
    }
    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof BoolMessage; //this.getClass();
    }
    public void flush(){

    }

    @Override
    public void accumulate(Message message) {
    }

    @Override
    public String fetch() {
        //return super.getDecorator().decorate(message);
        return getDecorator().decorate(message) + System.lineSeparator();
    }
}