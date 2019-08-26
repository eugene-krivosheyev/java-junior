package com.acme.edu.savers;

public class ConsoleSaver implements Saver {
    public void save(String message) {
        System.out.println(message);
    }
}