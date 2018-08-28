package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class IntMatrixMessage implements Message {
    private int[][] message;
    public IntMatrixMessage(int[][] message) {
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
        return decoratorVisitor.decorateIntMatrix(message) ;
    }
}
