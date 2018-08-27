package com.acme.edu.saver;

public interface LoggerSaver {
    void save(String message);

    default boolean checkNull(String message) {
        return message == null;
    }
}
