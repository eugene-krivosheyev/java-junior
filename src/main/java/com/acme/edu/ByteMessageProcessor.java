package com.acme.edu;

class ByteMessageProcessor implements MessageProcessor<Byte> {
    private Byte state = 0;

    @Override
    public boolean canAggregate(Byte message) {
        long aggregated = (long) state + (long) message;
        return Byte.MIN_VALUE <= aggregated && aggregated <= Byte.MAX_VALUE;
    }

    @Override
    public void process(Byte message) {
        if (!canAggregate(message)) {
            flush();
        }
        state = (byte) (state + message);
    }

    @Override
    public void flush() {
        System.out.print("primitive: " + state + "\n");
        state = 0;
    }
}