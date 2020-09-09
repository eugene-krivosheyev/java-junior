package com.acme.edu.message;

public class StringMessage implements LoggerMessage {
    public static final String PREFIX_STRING = "string: ";
    private static int counter = 1;

    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        AddPartOfStringDependingOnCounterToMessage();
        return PREFIX_STRING + message;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return currentState instanceof StringMessage;
    }

    @Override
    public LoggerMessage accumulate(LoggerMessage newMessage) {
        final StringMessage finalNewMessage = (StringMessage) newMessage;
        if (message.contains(finalNewMessage.message)) {
            counter++;
        } else {
            AddPartOfStringDependingOnCounterToMessage();
            counter = 1;
            message = message + " " + finalNewMessage.message;
        }
        return this;
    }

    private void AddPartOfStringDependingOnCounterToMessage(){
        message += (counter > 1) ? " (x" + counter + ")" + System.lineSeparator() : "";
    }

    @Override
    public boolean isNotOverflowed(LoggerMessage newMessage) {
        return true;
    }
}

