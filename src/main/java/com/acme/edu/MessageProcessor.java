package com.acme.edu;

interface MessageProcessor<T> {
    boolean canAggregate(T message);
    void process(T message);
    void flush();
}
