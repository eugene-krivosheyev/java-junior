package com.acme.edu.message;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.Decorator;

public class IntArrayMessage extends Message {
    private int [] message;

    public IntArrayMessage (int [] message, Decorator decorator) {
        super(decorator);
        this.message = message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() throws LoggerDecoratorException {
        getDecorator().setMessage(oneDimArrayAsString());
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    protected String oneDimArrayAsString() {
        if (message.length == 0) {
            return String.format("{%s}", System.lineSeparator());
        }
        StringBuilder arrayAsString = new StringBuilder("{");
        for (int i = 0; i < message.length - 1; i++) {
            arrayAsString.append(message[i]);
            arrayAsString.append(", ");
        }
        arrayAsString.append(message[message.length - 1]);
        arrayAsString.append("}");
        return arrayAsString.toString();
    }
}
