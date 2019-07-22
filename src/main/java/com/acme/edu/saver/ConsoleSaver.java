package com.acme.edu.saver;

public class ConsoleSaver implements Saver {
    private boolean isPrimitive = true;

    @Override
    public void save(String message) {
        System.out.println(message);
    }

    @Override
    public void setNotPrimitive() {
        isPrimitive = false;
    }

    @Override
    public boolean isPrimitive() {
        return isPrimitive;
    }
}
