package com.acme.edu.message;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.Decorator;

import java.util.ArrayList;
import java.util.Optional;

public class IntMessage extends Message {
    private int message;
    private ArrayList<IntMessage> integerArrayList;

    public IntMessage(int message, Decorator decorator) {
        super (decorator);
        this.message = message;
        this.integerArrayList = new ArrayList<IntMessage>();
    }

    public int getMessage() {
        return  message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        IntMessage downcastedMessage = (IntMessage) nextMessage;
        integerArrayList.add(downcastedMessage);
        return this;
    }

    @Override
    public String getDecoratedMessage() throws LoggerDecoratorException {
        Optional<Integer> result = integerArrayList.stream().map(e ->e.getMessage()).reduce((a, b) -> a + b);
        getDecorator().setMessage(result.toString());
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }
}
