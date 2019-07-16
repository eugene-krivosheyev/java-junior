package com.acme.edu.ooad;

public class LogConsoleSaver implements LogSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
