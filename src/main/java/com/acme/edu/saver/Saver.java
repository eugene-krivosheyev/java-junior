package com.acme.edu.saver;

public abstract class Saver {
    public void save(String message) {
        if (message != null) {
            this.output(message);
        }
    }

    abstract protected void output(String message);
}
