package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.INTEGER;

public class BooleanMessage extends Message {
    public BooleanMessage(boolean value) {
        super.prefix = INTEGER.getPrefix();
        super.value = String.valueOf(value);
    }
}
