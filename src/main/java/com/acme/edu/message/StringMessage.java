package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class StringMessage implements  Message{

    private String message;
    private static final String STRING = "string: ";

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return STRING + message;
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(((StringMessage) message).getMessage());
    }

    public String getMessage() {
        return message;
    }
}

