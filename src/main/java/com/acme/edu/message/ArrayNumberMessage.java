package com.acme.edu.message;

public class ArrayNumberMessage extends OverflowingMessage {

    public ArrayNumberMessage(long maxLimit, long minLimit, long number) {
        super(maxLimit, minLimit, number);
    }

    @Override
    protected OverflowingMessage createSpecificMessage(long number) {
        return new ArrayNumberMessage(maxLimit, minLimit, number);
    }

    @Override
    public boolean canAppend(Message message) {
        return message instanceof ArrayNumberMessage && checkLimits((ArrayNumberMessage) message);
    }
}
