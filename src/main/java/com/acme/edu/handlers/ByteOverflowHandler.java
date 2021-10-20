package com.acme.edu.handlers;

import com.acme.edu.messages.ByteMessage;
import com.acme.edu.messages.Message;

public class ByteOverflowHandler extends OverflowHandler {
    public ByteOverflowHandler() {
        negative = Byte.MIN_VALUE;
        positive = Byte.MAX_VALUE;
    }

    @Override
    public Message getMessage() {
        return new ByteMessage((byte) currentSum);
    }
}
