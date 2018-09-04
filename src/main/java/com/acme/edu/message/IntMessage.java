package com.acme.edu.message;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.Decorator;

import java.util.*;

public class IntMessage extends Message {
    private int message;
    private Collection<IntMessage> intMessageAccumulator;

    public IntMessage(int message, Decorator decorator) {
        super (decorator);
        this.message = message;
        this.intMessageAccumulator = new LinkedList<IntMessage>();
    }

    public int getMessage() {
        return  message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        IntMessage downcastedMessage = (IntMessage) nextMessage;
        intMessageAccumulator.add(downcastedMessage);
        return this;
    }

    @Override
    public String getDecoratedMessage() throws LoggerDecoratorException {
        Optional<Integer> result = intMessageAccumulator.stream().map(e ->e.getMessage()).reduce((a, b) -> a + b);
        getDecorator().setMessage(result.toString());
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }
}
