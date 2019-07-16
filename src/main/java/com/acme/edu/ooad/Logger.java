package com.acme.edu.ooad;

public class Logger {
    private LogMessageLengthFilter filter = new LogMessageLengthFilter(50);
    //Abstract Factory [GoF] + Registry [PoEAA]
    private LogSaver saver = AppRegistry.getSaverFactory().create();

    public void log(String message) {
        if (filter.allow(message)) {
            saver.save(message);
        }
    }
}
