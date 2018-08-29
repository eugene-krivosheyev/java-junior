package com.acme.edu.saver;

public interface Saver {
    default void save(String message) {
        if (message != null) {
            this.output(message);
        }
    }

    void output(String message);
}
