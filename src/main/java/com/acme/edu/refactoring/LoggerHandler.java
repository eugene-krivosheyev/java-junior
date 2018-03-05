package com.acme.edu.refactoring;

public abstract class LoggerHandler {
    /**
     * Template method
     * @param message
     */
    public void handle(Object message) {
        if (accumulate()) {
            decorate();
        }
    }

    protected abstract void decorate();

    protected abstract boolean accumulate();
}
