package com.acme.edu.refactoring;

public class LoggerHandler {
    LoggerDecorator decorator;
    LoggerAccumulator accumulator;

    /**
     * Template method
     * @param message
     */
    public void handle(Object message) {
        if (accumulator.accumulate()) {
            decorator.decorate();
        }
    }
}
