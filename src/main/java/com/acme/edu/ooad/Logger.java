package com.acme.edu.ooad;

public class Logger {
    //Field DI
    private LogFilter filter;
    private LogSaver saver;

    //Constructor DI
    public Logger(LogFilter filter, LogSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    //Setter DI
    public void setSaver(LogSaver saver) {
        this.saver = saver;
    }

    public void log(String message) {
        if (filter.allow(message)) {
            saver.save(message);
        }
    }
}
