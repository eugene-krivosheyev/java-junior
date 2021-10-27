package com.acme.edu.message;

import com.acme.edu.exception.IllegalMessageStateException;

public abstract class OverflowingMessage implements Message {
    protected static final String PRIMITIVE_PREFIX = "primitive: ";

    protected final long maxLimit;

    public long getMaxLimit() {
        return maxLimit;
    }

    public long getMinLimit() {
        return minLimit;
    }

    protected final long minLimit;

    private final long accumulator;

    public OverflowingMessage(long maxLimit, long minLimit, long number) {
        this.maxLimit = maxLimit;
        this.minLimit = minLimit;
        this.accumulator = number;
    }

    @Override
    public String getBody() {
        return PRIMITIVE_PREFIX + accumulator;
    }

    protected abstract OverflowingMessage createSpecificMessage(long number);

    protected long getAccumulator() {
        return accumulator;
    }

    protected boolean checkLimits(OverflowingMessage message) {
        return message.getMaxLimit() == getMaxLimit() && message.getMinLimit() == getMinLimit();
    }

    protected Message[] checkOverflow(long num) {
        long sum = num + accumulator;
        if (sum <= minLimit) {
            return new Message[]{createSpecificMessage(minLimit), createSpecificMessage(sum - minLimit)};
        } else if (sum >= maxLimit) {
            return new Message[]{createSpecificMessage(maxLimit), createSpecificMessage(sum - maxLimit)};
        } else {
            return new Message[]{createSpecificMessage(accumulator + num)};
        }
    }

    @Override
    public Message[] append(Message message) {
        if (!canAppend(message)) throw new IllegalMessageStateException("Expected same overflowing message type");
        OverflowingMessage numberMessage = (OverflowingMessage) message;
        return this.checkOverflow(numberMessage.getAccumulator());
    }
}
