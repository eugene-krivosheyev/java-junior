package com.acme.edu.ooad;

import java.io.File;

public class Logger {
    //Field DI
    private final LogFilter filter;
    private final LogSaver saver;

    //Constructor DI
    public Logger(LogFilter filter, LogSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(Command message) {
        if (filter.allow(message)) {
            saver.save(message);
        }
    }
}
