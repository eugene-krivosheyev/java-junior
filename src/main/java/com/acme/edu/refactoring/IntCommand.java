package com.acme.edu.refactoring;

public class IntCommand implements Command {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public boolean accumulate() {
        return false;
    }

    @Override
    public String decorate() {
        return null;
    }
}
