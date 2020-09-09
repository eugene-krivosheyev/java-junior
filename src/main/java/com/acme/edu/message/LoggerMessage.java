package com.acme.edu.message;

public interface LoggerMessage {
    public String getMessage();

    public boolean isSameType(LoggerMessage currentState);

    public LoggerMessage accumulate(LoggerMessage newMessage);

    public boolean isNotOverflowed(LoggerMessage newMessage);
}
