package com.acme.edu.saver;

public class SystemOutSaver implements Saver {

    @Override
    public void save(Object message) {
        System.out.println(message);
    }
}
