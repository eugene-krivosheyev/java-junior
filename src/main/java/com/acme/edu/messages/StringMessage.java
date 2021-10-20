package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.STRING;

public class StringMessage extends Message {
    public StringMessage(String value) {
        super.prefix = STRING.getPrefix();
        super.value = value;
    }
}
