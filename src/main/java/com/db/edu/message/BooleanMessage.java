package com.db.edu.message;

public class BooleanMessage extends Message<Boolean> {

    BooleanMessage(boolean message) {
        this.message = message;
    }

//    public void save(boolean)

    @Override
    public Message accumulate(Message message) {
        return null;
    }
}
