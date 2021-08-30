package com.acme.edu.saver;

public class ConsoleSaver implements Saver {
    public void save(String text) throws SaveException {
        if(text == null){
            throw new SaveException("Message is null.");
        }
        System.out.println(text);
    }
}
