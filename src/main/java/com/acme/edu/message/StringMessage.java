package com.acme.edu.message;


import java.util.Objects;

public class StringMessage implements Message {
    private static final String STRING = "string: ";
    private String  message;
    private int counter;

    private String  getMessage() {
        return message;
    }

    public StringMessage(String message) {
        this.message = message;
        this.counter = 1;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        return (comparedMessage instanceof StringMessage) && Objects.equals(this.message, ((StringMessage) comparedMessage).getMessage());
    }

    @Override
    public String getDecoratedMessage() {
        String decoratedMessage = STRING + this.message;
        if (this.counter != 1) {
            decoratedMessage += " (x" + this.counter + ")";
        }
        return decoratedMessage;
    }

    @Override
    public Message accumulate(Message message) {
        StringMessage stringMessage = (StringMessage) message;
        if (this.message.equals(stringMessage.getMessage())){
            this.counter++;
            return this;
        } else {
            this.message = stringMessage.getMessage();
            this.counter = 1;
            return this;
        }
    }
}
