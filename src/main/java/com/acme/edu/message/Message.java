package com.acme.edu.message;

public interface Message {
    @Override
    String toString();

    boolean isSameType(Message message);

    void updateAccumulator(Message message);

    Object getValue();

    boolean isOverFlow(Message message);
}
