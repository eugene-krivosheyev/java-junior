package com.acme.edu.message.type.arrays;
import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class IntMatrixMessage extends IntContainerMessage {
    public IntMatrixMessage(Object msg, boolean isSum) {
        super(msg, isSum, 2);
    }

    public IntMatrixMessage(com.acme.edu.message.type.arrays.IntArrayMessage message) {
        this(message.getData(), message.isSum());
    }

    @Override
    public String prefix() {
        return "primitives matrix: ";
    }
}
