package com.acme.edu.command;

public class LoggerMessage {
    public String getMessage() {
        return "";
    }

    public boolean isSameType(LoggerMessage currentState) {
        return true;
    }

    public LoggerMessage accumulate(LoggerMessage newMessage) {
        return newMessage;
    }

    public boolean isNotOverflowed(LoggerMessage newMessage) { return true;}
}
