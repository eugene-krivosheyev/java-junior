package com.acme.edu.message;


import com.acme.edu.loggerexceptions.AccumulatingException;
import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.Decorator;

public abstract class Message {
    private Decorator decorator;

    public abstract Message accumulate(Message nextMessage) throws AccumulatingException;

    public abstract String getDecoratedMessage() throws LoggerDecoratorException;

    public abstract boolean isSameTypeOf(Message message);

    public Message(Decorator decorator) {
        this.decorator = decorator;
    }

    public Decorator getDecorator() {
        return decorator;
    }

    public void setDecorator(Decorator decorator) {
        this.decorator = decorator;
    }
}
