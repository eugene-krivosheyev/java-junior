package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class ObjectMessage implements Message{
    private Object message;

    public ObjectMessage(Object message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String accept(DecoratorVisitor decoratorVisitor) {
        return decoratorVisitor.decorateObject(this.message);
    }
}
