package com.acme.edu;

public class LoggerMessage {
    public String message;

    public String getMessage() {
        return message;
    }

    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }

    public void accumulate(LoggerMessage newMessage) {
        message += newMessage.message;
    }
}
