package com.acme.edu.message;

public class SingleNumberMessage extends OverflowingMessage {

    public SingleNumberMessage(long maxLimit, long minLimit, long number) {
        super(maxLimit, minLimit, number);
    }

    @Override
    public boolean canAppend(Message message) {
        return message instanceof SingleNumberMessage && checkLimits((SingleNumberMessage) message);
    }

    @Override
    protected OverflowingMessage createSpecificMessage(long number) {
        return new SingleNumberMessage(maxLimit, minLimit, number);
    }
}
