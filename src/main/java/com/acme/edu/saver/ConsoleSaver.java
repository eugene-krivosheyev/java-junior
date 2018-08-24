package com.acme.edu.saver;

public class ConsoleSaver implements LoggerSaver{
    public void save(String message) {
        System.out.println(message);
    }
}
