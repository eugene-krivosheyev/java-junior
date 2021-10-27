package com.acme.edu.message;

public interface Message {
    Object getData();

    boolean isEmpty();

    boolean isEndLogging();

    boolean isSum();

    boolean isSameType(Message message);

    void setMsg(Object message);

    void setMsg(Object message, boolean isSum);

    Message add(Message message) throws IllegalMessageExeption;

    void setEndLogging(boolean isEnd);

    String prefix();
}
