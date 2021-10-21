package com.acme.edu.common;

public interface Message {
    String getDecoratedString();
    boolean isSameType(Message message);
    void accumulate(Message message, Printer printer);
}