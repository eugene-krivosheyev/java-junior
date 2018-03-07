package com.acme.edu.message;

public interface Message {
    void accumulate();
    boolean isUsed();
    void flush();
}