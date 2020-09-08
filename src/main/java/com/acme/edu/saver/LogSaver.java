package com.acme.edu.saver;

public class LogSaver implements Saver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
