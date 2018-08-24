package com.acme.edu.message;

public class FlushMessage implements Message {
    public FlushMessage(){
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
