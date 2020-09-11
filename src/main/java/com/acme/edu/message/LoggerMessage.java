package com.acme.edu.message;

public interface LoggerMessage {
    String getMessage();

    boolean isSameType(LoggerMessage currentState);

    LoggerMessage accumulate(LoggerMessage newMessage);

    default boolean isNotOverflowed(LoggerMessage newMessage){
        return true;
    };
}
