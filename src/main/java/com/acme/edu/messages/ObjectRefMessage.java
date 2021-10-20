package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.OBJECT_REFERENCE;

public class ObjectRefMessage extends Message {
    public ObjectRefMessage(String value) {
        super.prefix = OBJECT_REFERENCE.getPrefix();
        super.value = value;
    }
}
