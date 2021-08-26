package com.db.edu;

public interface Message {

    void accumulate(Message message);

    default boolean typeEquals(Message message) {
        return this.getClass().equals(message.getClass());
    }

    void printAccumulated();

}
