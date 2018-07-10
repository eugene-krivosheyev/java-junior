package com.db.edu.simplelogger.saver;

public interface Saver<T> {
    void save(T message);
}
