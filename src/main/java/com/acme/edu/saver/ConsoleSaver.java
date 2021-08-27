package com.acme.edu.saver;

public class ConsoleSaver implements Saver {
    public void save(String text) {
        System.out.println(text);
    }
}
