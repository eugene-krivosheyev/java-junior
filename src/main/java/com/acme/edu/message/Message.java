package com.acme.edu.message;

public interface Message {
    public Message accumulate(Message message);

    public String decorate();

    public boolean isAbleToAccumulate(Message message);
}
