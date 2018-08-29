package com.acme.edu.message;


import com.acme.edu.decorator.DecoratorVisitor;

import java.util.Objects;

public class StringMessage implements Message {
    private String  message;
    private int counter;

    public StringMessage(String message) {
        this.message = message;
        this.counter = 1;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        return (comparedMessage instanceof StringMessage) && Objects.equals(this.message, ((StringMessage) comparedMessage).message);
    }

    @Override
    public Message accumulate(Message message) {
        this.counter++;
        return this;
    }

    @Override
    public String accept(DecoratorVisitor decoratorVisitor) {
        return decoratorVisitor.decorateString(this.message, this.counter);
    }

    public String getMessage() {
        return message;
    }

    public int getCounter() {
        return counter;
    }
}
