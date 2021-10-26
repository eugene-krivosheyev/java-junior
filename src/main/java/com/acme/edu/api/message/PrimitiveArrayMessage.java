package com.acme.edu.api.message;

import java.util.Arrays;

public class PrimitiveArrayMessage extends ArrayMessage {
    private final int[] values;

    public PrimitiveArrayMessage(int[] array, boolean printAsArray) {
        if (array == null) throw new NullPointerException("You try to write a Null Array");
        setPrintAsArray(printAsArray);
        values = array;
        setPrefix("primitives array: ");
        setValue(makeTheString(array));
    }

    public PrimitiveArrayMessage(int[] array) {
        this(array, false);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof PrimitiveArrayMessage;
    }

    @Override
    String streamCount() {
        return Arrays.stream(values).mapToObj(IntegerMessage::new).reduce(IntegerMessage::IntegerMessageReducer).get().getMessageAsString();
    }
}
