package com.acme.edu.ooad;

public abstract class LogDefaultSaver implements LogSaver {
    @Override
    public void save(Command message) {
        if (message == null) throw new IllegalArgumentException();
    }
}
