package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.saver.Saver;

public abstract class Message {
    private Saver saver;
    private Decorator decorator;
    public Message(Saver saver, Decorator decorator) {
        setSaver(saver);
        setDecorator(decorator);
    }
    public void setSaver(Saver saver) {
        this.saver = saver;
    }
    public Saver getSaver() {
        return saver;
    }
    public void setDecorator(Decorator decorator) {
        this.decorator = decorator;
    }
    public Decorator getDecorator() {
        return decorator;
    }
    public abstract Message log(Message message);
    public abstract boolean isSameTypeOf(Message message);
    public abstract void flush();
    public abstract void accumulate(Message message) throws MessageException;
    public abstract String fetch();
}
