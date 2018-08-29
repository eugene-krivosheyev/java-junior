package com.acme.edu.saver;

public abstract class Saver {
    public void save(String message) throws Exception {
        if (message == null) throw new IllegalArgumentException("null");
    }
}
