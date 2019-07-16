package com.acme.edu.ooad;

public class LogConsoleSave implements LogSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
