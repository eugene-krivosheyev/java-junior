package com.acme.edu.saver;

public class DefaultSaver extends Saver {
    @Override
    protected void output(String message) {
        System.out.println(message);
    }
}
