package com.acme.edu.utils;

public class ConsoleSaver implements Saver {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
