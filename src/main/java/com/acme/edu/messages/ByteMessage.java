package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.BYTE;

public class ByteMessage extends Message {
    public ByteMessage(byte value) {
        super.prefix = BYTE.getPrefix();
        super.value = String.valueOf(value);
    }
}
