package com.acme.edu.message;

public class StringMessage extends Message {
    private String message;
    private int countOfStrings;

    public String getMessage() {
        return message;
    }

    public int getCountOfStrings() {
        return countOfStrings;
    }

    public StringMessage(String message) {
        this(message, 1);
    }

    private StringMessage(String message, int countOfStrings) {
        this.message = message;
        this.countOfStrings = countOfStrings;
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(this.message, this.countOfStrings + ((StringMessage) message).getCountOfStrings());
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof StringMessage && ((StringMessage) message).getMessage().equals(this.message);
    }
}
