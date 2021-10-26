package com.acme.edu.message.type.arrays;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class IntArrayMessage extends IntContainerMessage {

    public IntArrayMessage(Object msg, boolean isSum) {
        super(msg, isSum, 1);
    }

    public IntArrayMessage(IntArrayMessage message) {
        this(message.getData(), message.isSum());
    }

    @Override
    public String prefix() {
        return "primitives array: ";
    }
}
