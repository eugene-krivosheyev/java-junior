package com.acme.edu.message;

public interface Message {
    public Message accumulate(Message message);
    public Message decorate();

    boolean isInstanceOf(Message message);
    String getDecoratedString();
}
