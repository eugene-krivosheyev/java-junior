package com.acme.edu.refactoring;

public class StringCommand implements Command {
    @Override
    public boolean accumulate() {
        return false;
    }

    @Override
    public String decorate() {
        return null;
    }
}
