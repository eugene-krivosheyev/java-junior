package com.acme.edu.messagelog;

public class MatrixIntMessage extends Message {
    private static final String TYPE_NAME = "primitives matrix";
    private final int[][] value;

    public MatrixIntMessage(int[] ... message) {
        this.value = message.clone();
        type = TYPE_NAME;
    }

    public int[][] getValue() {
        return value.clone();
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return false;
    }
}
