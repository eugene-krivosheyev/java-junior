package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

public abstract class Message {
    private Decorator decorator;
    public Message(Decorator decorator) {
        setDecorator(decorator);
    }
    public Decorator getDecorator() {
        return decorator;
    }
    public void setDecorator(Decorator decorator) {
        this.decorator = decorator;
    }
    public abstract Message log(Message message);
    public abstract boolean isSameTypeOf(Message message);
    public abstract void flush();
    public abstract void accumulate(Message message);
    public abstract String fetch();
}
