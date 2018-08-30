package com.acme.edu.message;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.Decorator;

import java.util.Objects;

public class StringMessage extends Message {
    private String message;
    private int counter;

    public StringMessage(String message, Decorator decorator) {
        super(decorator);
        this.message = message;
        counter  = 1;
    }
    private StringMessage (String message, int counter, Decorator decorator) {
        super(decorator);
        this.message = message;
        this.counter  = counter;
    }

    public int getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        return  new StringMessage(message, counter+1, getDecorator());
    }

    @Override
    public String getDecoratedMessage() throws LoggerDecoratorException {
        String quantityString = counter > 1 ? String.format("(x%d)", counter): "";
        String formattedMessage = String.format("%s %s", message, quantityString);
        getDecorator().setMessage(formattedMessage);
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        if (! (message instanceof StringMessage)) return false;
        StringMessage downcastedMessage = (StringMessage) message;
        return Objects.equals(this.message, downcastedMessage.message);
    }
}
