package com.acme.edu.refactoring;

public class IntHandler implements LoggerHandler {
    @Override
    public void handle(Object message) {
        (int)message
    }
}
