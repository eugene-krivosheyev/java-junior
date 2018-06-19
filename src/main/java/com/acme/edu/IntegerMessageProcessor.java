package com.acme.edu;

class IntegerMessageProcessor implements MessageProcessor<Integer> {
    private Integer state = 0;

    @Override
    public boolean canAggregate(Integer message) {
        long aggregated = (long) state + (long) message;
        return Integer.MIN_VALUE <= aggregated && aggregated <= Integer.MAX_VALUE;
    }

    @Override
    public void process(Integer message) {
        if (!canAggregate(message)) {
            flush();
        }
        state += message;
    }

    @Override
    public void flush() {
        System.out.print("primitive: " + state + "\n");
        state = 0;
    }
}