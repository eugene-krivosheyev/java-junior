package com.acme.edu;

public class ConcoleSaver implements SuperSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
