package com.acme.edu.message;

import com.acme.edu.exception.IllegalMessageStateException;

public abstract class OverflowingMessage implements Message {
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    protected final long maxLimit;
    protected final long minLimit;

    private long accumulator;

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
        return message.maxLimit == maxLimit && message.minLimit == minLimit;
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
