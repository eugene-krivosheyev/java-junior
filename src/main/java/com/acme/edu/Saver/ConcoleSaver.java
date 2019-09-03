package com.acme.edu.Saver;

public class ConcoleSaver implements SuperSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
