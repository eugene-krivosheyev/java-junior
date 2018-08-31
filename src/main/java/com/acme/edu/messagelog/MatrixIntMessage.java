package com.acme.edu.messagelog;

public class MatrixIntMessage extends Message<int[][]> {
    private static final String TYPE_NAME = "primitives matrix";

    public MatrixIntMessage(int[] ... message) {
        this.value = message.clone();
        type = TYPE_NAME;
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
