package com.acme.edu.message.type.arrays;
import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class IntMultiMatrixMessage extends IntContainerMessage {
    public IntMultiMatrixMessage(Object msg, boolean isSum) {
        super(msg, isSum, 4);
    }

    public IntMultiMatrixMessage(com.acme.edu.message.type.arrays.IntArrayMessage message) {
        this(message.getData(), message.isSum());
    }

    @Override
    public String prefix() {
        return "primitives multimatrix: ";
    }
}
