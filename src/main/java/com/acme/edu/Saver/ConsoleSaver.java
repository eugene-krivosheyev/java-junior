package com.acme.edu.Saver;

public class ConsoleSaver implements Saver {
    public void save(String message) {
        System.out.println(message);
    }
}
