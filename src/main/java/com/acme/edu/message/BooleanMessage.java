package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class BooleanMessage implements Message{
    private boolean message;

    public BooleanMessage(boolean message) {
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
        return decoratorVisitor.decorateBoolean(this.message);
    }
}
