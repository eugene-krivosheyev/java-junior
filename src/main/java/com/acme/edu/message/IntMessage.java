package com.acme.edu.message;

public class IntMessage extends Message {
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    protected long maxLimit = Integer.MAX_VALUE;
    protected long minLimit = Integer.MIN_VALUE;

    private long number;
    private boolean minOverflow = false;
    private boolean maxOverflow = false;

    public IntMessage(long number) {
        super(Type.INT);
        this.number = number;
        changeBody();
    }

    public void addToMessage(IntMessage message) {
        addNumber(message.number);
    }
    public boolean isOverflow() {
        return minOverflow || maxOverflow;
    }
    private void addNumber(long num) {
        checkOverflow(num);
        changeBody();
    }

    private void checkOverflow(long num) {
        long sum = num + number;
        minOverflow = sum <= minLimit;
        maxOverflow = sum >= maxLimit;
        if (minOverflow) {
            number = sum - minLimit;
        } else if (maxOverflow) {
            number = sum - maxLimit;
        } else {
            number += num;
        }
    }

    private void changeBody() {
        body = "";
        if (minOverflow) {
            body += PRIMITIVE_PREFIX + minLimit + System.lineSeparator();
        } else if (maxOverflow) {
            body += PRIMITIVE_PREFIX + maxLimit + System.lineSeparator();
        }
        body += PRIMITIVE_PREFIX + number;
    }

}
