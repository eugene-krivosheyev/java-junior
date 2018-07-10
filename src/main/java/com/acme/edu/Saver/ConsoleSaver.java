package com.acme.edu.Saver;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
