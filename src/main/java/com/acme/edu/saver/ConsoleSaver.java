package com.acme.edu.saver;

public class ConsoleSaver implements Saver {



    @Override
    public void save(String string) {
        System.out.println(string);
    }
}
