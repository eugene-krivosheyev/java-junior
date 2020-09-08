package com.acme.edu;

public interface LoggerMessage {
//    public String message;

    String getMessage();

    boolean isSameType(LoggerMessage currentState);

    void accumulate(LoggerMessage newMessage);
}
