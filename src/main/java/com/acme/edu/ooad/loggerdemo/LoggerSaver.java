package com.acme.edu.ooad.loggerdemo;

public interface LoggerSaver {
    public static final int i = 0;

    /**
     * Contract (DbC)
     * 1. Pre-conditions
     * 2. Post-conditions (side effects)
     * 3. Invariants
     */
    void save(String message);
}
