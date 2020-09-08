package com.acme.edu.saver;

public class ConsoleSaver implements Saver {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
