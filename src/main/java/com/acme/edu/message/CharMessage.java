package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class CharMessage implements Message {
    private char message;

    public CharMessage(char message) {
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
        return decoratorVisitor.decorateChar(this.message);
    }
}
