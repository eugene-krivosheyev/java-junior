package com.db.edu.simplelogger.saver;

public class ConsoleSaver<T> implements Saver<T> {
    public void save(T message) {
        System.out.println(message);
    }
}
