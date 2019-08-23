package com.acme.edu.Saver;

public class ConsoleSaver implements Saver {



    @Override
    public void save(String string) {
        System.out.println(string);
    }
}
