package com.acme.edu.api.message;

import org.mockito.internal.matchers.Null;

import java.util.Arrays;

public class PrimitiveMatrixMessage extends ArrayMessage {
    private int[][] values;

    public PrimitiveMatrixMessage(int[][] value, boolean printAsArray) throws NullMessageException {
        if (value == null) {
            throw new NullMessageException("You try to write a Null Matrix");
        }
        setPrintAsArray(printAsArray);
        values = value;
        setPrefix("primitives matrix: ");
        setValue(make2DString(value));
    }


    public PrimitiveMatrixMessage(int[][] value) throws NullMessageException {
        this(value, false);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof PrimitiveMatrixMessage;
    }

    @Override
    String streamCount() {
        return Arrays.stream(values).flatMapToInt(Arrays::stream).mapToObj(IntegerMessage::new).reduce(IntegerMessage::IntegerMessageReducer).get().getMessageAsString();
    }

    private String make2DString(int[][] array) {
        StringBuilder arrayTo2DString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayTo2DString.append("{" + System.lineSeparator());
            }
            arrayTo2DString.append(makeTheString(array[i]) + System.lineSeparator());
            if (i == array.length - 1) {
                arrayTo2DString.append("}");
            }
        }
        return arrayTo2DString.toString();
    }
}
