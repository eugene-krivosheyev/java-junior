package com.acme.edu;

public class State {
    enum Type {
        UNDEFINED,
        STRING,
        INTEGER,
        BYTE
    }

    private Type previousType = Type.UNDEFINED;
    private Type currentType = Type.UNDEFINED;

    public void setNextType(Type nextType) {
        previousType = currentType;
        currentType = nextType;
    }
    public Type getCurrentType() {
        return currentType;
    }
    public Type getPreviousType() {
        return previousType;
    }
}
