package com.db.edu.Message;

public interface Message {

    void accumulate(Message message);

    default boolean typeEquals(Message message) {
        return this.getClass().equals(message.getClass());
    }

    void close();

    String decorate();

    String getValue();

}
