package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.INTEGER;

public class IntegerMessage extends Message {
    public IntegerMessage(int value) {
        super.prefix = INTEGER.getPrefix();
        super.value = String.valueOf(value);
    }
}
