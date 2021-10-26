package com.acme.edu.message;

import com.acme.edu.exception.IllegalMessageStateException;

public abstract class OverflowingMessage implements Message {
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    protected final long maxLimit;
    protected final long minLimit;

    private long accumulator;
    private boolean minOverflow = false;
    private boolean maxOverflow = false;

    public OverflowingMessage(long maxLimit, long minLimit, long number) {
        this.maxLimit = maxLimit;
        this.minLimit = minLimit;
        this.accumulator = number;
    }

    @Override
    public String getBody() {
        String body = "";
        if (minOverflow) {
            body += PRIMITIVE_PREFIX + minLimit + System.lineSeparator();
        } else if (maxOverflow) {
            body += PRIMITIVE_PREFIX + maxLimit + System.lineSeparator();
        }
        body += PRIMITIVE_PREFIX + accumulator;
        return body;
    }

    protected long getAccumulator() {
        return accumulator;
    }

    protected boolean checkLimits(OverflowingMessage message) {
        return message.maxLimit == maxLimit && message.minLimit == minLimit;
    }

    protected void checkOverflow(long num) {
        long sum = num + accumulator;
        minOverflow = sum <= minLimit;
        maxOverflow = sum >= maxLimit;
        if (minOverflow) {
            accumulator = sum - minLimit;
        } else if (maxOverflow) {
            accumulator = sum - maxLimit;
        } else {
            accumulator += num;
        }
    }

    @Override
    public Message append(Message message) {
        if (!canAppend(message)) throw new IllegalMessageStateException("Expected same overflowing message type");
        OverflowingMessage numberMessage = (OverflowingMessage) message;
        checkOverflow(numberMessage.getAccumulator());
        return this;
    }
}
