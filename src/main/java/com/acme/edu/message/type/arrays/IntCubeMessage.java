package com.acme.edu.message.type.arrays;
import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class IntCubeMessage extends IntContainerMessage {
    public IntCubeMessage(Object msg, boolean isSum) {
        super(msg, isSum, 3);
    }

    public IntCubeMessage(com.acme.edu.message.type.arrays.IntArrayMessage message) {
        this(message.getData(), message.isSum());
    }

    @Override
    public String prefix() {
        return "primitives cube: ";
    }
}
