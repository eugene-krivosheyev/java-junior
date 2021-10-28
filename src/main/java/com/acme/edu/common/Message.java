package com.acme.edu.common;

public interface Message {
    String getDecoratedString();
    boolean isSameType(Message message);
    Message accumulate(Message message);
}
