package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.ARRAY;

public class PrimitiveArrayMessage extends Message{
    public PrimitiveArrayMessage(String value) {
        super.prefix = ARRAY.getPrefix();
        super.value = String.valueOf(value);
    }
}
