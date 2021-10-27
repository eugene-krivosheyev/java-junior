package com.acme.edu.message;

public interface Message {
    /**
     * @return First messages of the array contain data about overflow.
     * The last one message (with index = Message[].lenght - 1) contains remainder of
     * append operation.
     * If there is no overflow, it returns an array with one message.
     */
    Message[] append(Message message);

    String getBody();

    boolean canAppend(Message message);
}
