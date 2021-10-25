package com.acme.edu.messages;

public interface Message {
    Message accumulate(Message message);
    boolean isSameType(Message message);
    String getBody();
    String flush();
    void init();
}
