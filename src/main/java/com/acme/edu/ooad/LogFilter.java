package com.acme.edu.ooad;

public interface LogFilter {
    public static final int MAX_VAL = 0;
    public boolean allow(Command message);

    int getSeverty();

    static public void m() {

    }

    default int getDoublrSeverity() {
        return this.getSeverty() * 2;
    }
}
