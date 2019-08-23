package com.acme.edu.ooaddemo2;

public class SuperConsoleSaver implements SuperSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
