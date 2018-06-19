package com.acme.edu;

import java.util.Objects;

class StringMessageProcessor implements MessageProcessor<String> {
    private long count = 0;
    private String state = null;

    @Override
    public boolean canAggregate(String message) {
        return Objects.equals(message, state) && count != Long.MAX_VALUE;
    }

    @Override
    public void process(String message) {
        if (!canAggregate(message)) {
            flush();
        }
        state = message;
        count++;
    }

    @Override
    public void flush() {
        System.out.print("string: " + state);
        if (count > 1) {
            System.out.printf(" (x%s)", count);
        }
        System.out.print("\n");
        count = 0;
        state = null;
    }
}