package com.db.ooad;

public class ConsoleSaver implements LoggerSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
