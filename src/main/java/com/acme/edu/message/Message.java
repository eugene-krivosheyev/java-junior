package com.acme.edu.message;

public interface Message {

    Message append(Message message);

    String getBody();

    boolean canAppend(Message message);
}
