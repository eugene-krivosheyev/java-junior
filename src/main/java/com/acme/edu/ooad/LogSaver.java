package com.acme.edu.ooad;

@FunctionalInterface
public interface LogSaver {
    Object save(Command message) throws Exception;
}
