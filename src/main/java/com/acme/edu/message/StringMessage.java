package com.acme.edu.message;

public class StringMessage extends LoggerMessage {
    public static final String PREFIX_STRING = "string: ";
    private static int counter = 1;

    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        message += (counter > 1) ? " (x" + counter + ")" + System.lineSeparator() : "";
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
            message += (counter > 1) ? " (x" + counter + ")" + System.lineSeparator() : "";
            counter = 1;
            message = message + " " + finalNewMessage.message;
            //message = finalNewMessage.message;
        }
        return this;
    }
}

