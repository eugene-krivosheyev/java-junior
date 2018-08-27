package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class Int2DimArrayMessage extends Message {
    IntArrayMessage[] message;

    public Int2DimArrayMessage(int[][] message, Decorator decorator) {
        super(decorator);
        this.message = new IntArrayMessage[message.length];
        for (int i = 0; i < this.message.length; i++) {
            this.message[i] = new IntArrayMessage(message[i], getDecorator());
        }
    }

    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        String[] arrayOfIntsAsString = new String[message.length];
        for (int i = 0; i < message.length; i++) {
            arrayOfIntsAsString[i] = message[i].oneDimArrayAsString();
        }
        String joinedArraysAsStrings = String.join(System.lineSeparator(), arrayOfIntsAsString);
        String finalResult = "{" + System.lineSeparator() +
                joinedArraysAsStrings + System.lineSeparator() + "}";
        getDecorator().setMessage(finalResult);
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
