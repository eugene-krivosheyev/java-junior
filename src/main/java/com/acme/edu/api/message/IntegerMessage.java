package com.acme.edu.api.message;

public class IntegerMessage extends SummableMessage {
    public IntegerMessage(int value) {
        setCurrentSum(value);
        setPrefix("primitive: ");
        setValue(String.valueOf(value));
        setMax(Integer.MAX_VALUE);
        setMin(Integer.MIN_VALUE);
    }

    public static IntegerMessage IntegerMessageReducer(IntegerMessage start, IntegerMessage add) {
        return (IntegerMessage) start.accumulate(add);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof IntegerMessage;
    }

    @Override
    protected SummableMessage getNewMessageOfMyType(long value) {
        return new IntegerMessage((int) value);
    }
}
