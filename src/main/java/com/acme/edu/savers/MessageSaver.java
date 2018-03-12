package com.acme.edu.savers;

@FunctionalInterface
public interface MessageSaver {
    void output(String message);
}
