package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.MATRIX;

public class PrimitiveMatrixMessage extends Message {
    public PrimitiveMatrixMessage(String value) {
        super.prefix = MATRIX.getPrefix();
        super.value = String.valueOf(value);
    }
}
