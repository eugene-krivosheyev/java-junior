package com.acme.edu.message;

import java.util.Objects;

public class StringMessage implements Message {
    private String message;
    private int counter;

    public StringMessage(String message) {
        this.message = message;
        counter  = 1;
    }
    private StringMessage (String message, int counter) {
        this.message = message;
        this.counter  = counter;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        return  new StringMessage(message, counter+1);
    }

    @Override
    public String getDecoratedMessage() {
        String quantityString = counter >1 ? String.format("(x%d)", counter): "";
        return String.format("%s: %s %s%s","string", message, quantityString, System.lineSeparator() );
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        if (! (message instanceof StringMessage)) return false;
        StringMessage downcastedMessage = (StringMessage) message;
        return Objects.equals(this.message, downcastedMessage.message);
    }
}
