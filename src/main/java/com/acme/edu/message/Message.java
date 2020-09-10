package com.acme.edu.message;

public interface Message {

    boolean isSameType(Message message);

    void updateAccumulator(Message message);

    Object getValue();

    boolean needFlush(Message message);
}
