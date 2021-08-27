package com.acme.edu.savers;

public class ConsoleSaver extends AbstractSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
