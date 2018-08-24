package com.acme.edu;

public interface Message {
    public String decorate();
    public Message accumulate(Message message);

    boolean isSameType(Message message);

}
