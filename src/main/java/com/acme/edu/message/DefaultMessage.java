package com.acme.edu.message;

public class DefaultMessage implements LoggerMessage{
    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return true;
    }

    @Override
    public LoggerMessage accumulate(LoggerMessage newMessage) {
        return newMessage;
    }
}
