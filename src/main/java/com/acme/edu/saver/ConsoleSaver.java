package com.acme.edu.saver;

public class ConsoleSaver implements Saver {
    @Override
    public void save(String message) {
        if (message == null) throw new IllegalArgumentException("String argument is null");
        System.out.println(message);
    }
}
