package com.acme.edu.saver;

public interface Saver {
    default void save(String message) throws SavingException {
        if (message != null) {
            this.output(message);
        } else {
            throw new SavingException("Saver received null message", 1);
        }
    }

    void output(String message) throws SavingException;
}
