package com.acme.edu;

public class ConsoleSaver extends LoggerSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
