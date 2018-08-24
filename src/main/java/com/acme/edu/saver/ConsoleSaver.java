package com.acme.edu.saver;

public class ConsoleSaver implements Saver {
    public void save(String message) {
        System.out.println(message);
    }
}
