package com.acme.edu;

public class ConsoleSaver implements Saver {
    public void save(String message) {
        System.out.println(message);
    }
}
