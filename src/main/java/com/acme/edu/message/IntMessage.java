package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class IntMessage implements Message {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        if (!(comparedMessage instanceof IntMessage)) return false;
        IntMessage castedMessage = (IntMessage) comparedMessage;
        long sum = (long) castedMessage.message + (long) this.message;
        return sum <= Integer.MAX_VALUE && sum >= Integer.MIN_VALUE;
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
