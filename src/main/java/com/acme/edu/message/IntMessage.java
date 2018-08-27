package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class IntMessage implements Message {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        return  (comparedMessage instanceof ByteMessage);
    }

    @Override
    public Message accumulate(Message message) {
        IntMessage intMessage = (IntMessage) message;
        this.message += intMessage.message;
        return this;
    }

    @Override
    public String accept(DecoratorVisitor decoratorVisitor) {
        return decoratorVisitor.decorateInt(this.message);
    }
}
