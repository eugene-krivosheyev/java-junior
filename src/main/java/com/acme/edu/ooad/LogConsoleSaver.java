package com.acme.edu.ooad;

public class LogConsoleSaver implements LogSaver {
    @Override
    public void save(Command message) {
        System.out.println(message);
    }
}
