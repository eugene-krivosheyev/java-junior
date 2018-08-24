package com.acme.edu.message;

public interface Message {
    public boolean isSameTypeOf(Message message);
    String getDecoratedMessage();
    public Message accumulate(Message message);
}
