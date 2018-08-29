package com.acme.edu.saver;

public class DefaultSaver implements Saver {
    @Override
    public void output(String message) {
        System.out.println(message);
    }
}
