package com.acme.edu.ooad.loggerdemo;

public class Logger {
    public void log(String message) {
        if (!filter(message)) { //Impl: content, severity, ...
            save(message); //Impl: console, file, ...
        }
    }

    private void save(String message) {
        
    }

    private boolean filter(String message) {
        return false;
    }
}
