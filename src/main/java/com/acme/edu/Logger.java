package com.acme.edu;

public class Logger {
    private LoggerFilter filter;
    private Saver saver;

    //DI
    public Logger(LoggerFilter filter, Saver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(int message) {
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}







