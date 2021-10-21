package com.acme.edu;

import com.acme.edu.message.*;

public class MessageGenerator {

    public Message getMessage(int message) {
        return new IntegerMessage(message);
    }

    public Message getMessage(byte message) {
        return new ByteMessage(message);
    }

    public Message getMessage(char message) {
        return new CharacterMessage(message);
    }

    public Message getMessage(String message) {
        return new StringMessage(message);
    }

    public Message getMessage(boolean message) {
        return new BooleanMessage(message);
    }

    public Message getMessage(Object message) {
        return new ObjectMessage(message);
    }
}
