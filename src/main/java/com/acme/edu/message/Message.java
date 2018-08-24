package com.acme.edu.message;


public interface Message {
    public Message accumulate(Message nextMessage);

    public String getDecoratedMessage();

    boolean isSameTypeOf(Message message);

}
