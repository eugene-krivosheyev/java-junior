package com.acme.edu;

class DefaultMessageProcessor<T> implements MessageProcessor<T> {
    private T state;
    private final String format;

    DefaultMessageProcessor(String format) {
        this.format = format;
    }

    @Override
    public boolean canAggregate(T message) {
        return true;
    }

    @Override
    public void process(T message) {
        flush();
        state = message;
    }

    @Override
    public void flush() {
        System.out.printf(format, state);
    }
}
