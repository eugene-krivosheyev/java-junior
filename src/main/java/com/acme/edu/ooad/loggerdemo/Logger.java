package com.acme.edu.ooad.loggerdemo;

public class Logger {
    private LoggerSaver saver = new ConsoleSaver();
    private LoggerFilter filter = new ContentFilter();

    public void log(String message) {
        if (!filter.filter(message)) { //Impl: content, severity, ...
            saver.save(message); //Impl: console, file, ...
        }
    }
}
