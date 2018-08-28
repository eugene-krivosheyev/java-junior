package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

abstract public class Message {
//    private Decorator decorator;
/*
    public Message(Decorator decorator) {
        this.decorator = decorator;
    }
*/
    abstract public Message accumulate(Message message);

    public String decorate(Decorator decorator) {
        return decorator.decorate(this);
    }

    abstract public boolean isAbleToAccumulate(Message message);
}
