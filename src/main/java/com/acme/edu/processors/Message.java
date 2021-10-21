package com.acme.edu.processors;

public interface Message {

    Message accumulate(Message message);

    boolean isSameType(Message message);

    String getBody();

    void flush();
}
