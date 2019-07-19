package com.acme.edu;

public class ConsoleSaver implements Saver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
