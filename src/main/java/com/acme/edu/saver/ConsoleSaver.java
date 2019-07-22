package com.acme.edu.saver;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String message) {
        System.out.print(message);
    }
}
