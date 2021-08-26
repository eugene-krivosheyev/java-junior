package com.acme.edu.ooad.message;

public interface Message {
    void clean();
    Message process(Message newMessage);
    String toString();
    boolean isNeedToFlush(Message newMessage);
    boolean equalValues(Message message);
    Object getValue();
    boolean sameTypeOf(Message message);
}
