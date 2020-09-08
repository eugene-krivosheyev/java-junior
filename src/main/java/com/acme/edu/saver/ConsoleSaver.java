package com.acme.edu.saver;

public class ConsoleSaver implements LoggerSaver {
    @Override
    public void save(String representation) {
        System.out.println(representation);
    }
}
