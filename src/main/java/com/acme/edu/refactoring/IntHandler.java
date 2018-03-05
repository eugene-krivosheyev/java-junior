package com.acme.edu.refactoring;

public class IntHandler extends LoggerHandler {

    @Override
    protected void decorate() {

    }

    @Override
    protected boolean accumulate() {
        return false;
    }
}
