package com.acme.edu.mylogger.savers;

public class SuperConsoleSaver implements SuperSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
