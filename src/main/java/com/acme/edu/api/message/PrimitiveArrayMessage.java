package com.acme.edu.api.message;

import java.util.Arrays;

public class PrimitiveArrayMessage extends ArrayMessage {
    private int[] values;

    public PrimitiveArrayMessage(int[] array, boolean printAsArray)throws NullMessageException {
        if (array == null) {
            throw new NullMessageException("You try to write a Null Array");
        }
        setPrintAsArray(printAsArray);
        values = array;
        setPrefix("primitives array: ");
        setValue(makeTheString(array));
    }

    public PrimitiveArrayMessage(int[] array) throws NullMessageException{
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
