package com.acme.edu.ooad.loggerdemo;

public class Logger {
    private LoggerSaver saver; //field injection

    public Logger(LoggerSaver saver) { //DI (constructor injection)
        this.saver = saver;
    }

    public void setSaver(LoggerSaver saver) { //setter injection
        this.saver = saver;
    }

    public void log(LoggerMessage message) {
        if (!message.filter()) { //Impl: content, severity, ...
            saver.save(message); //Impl: console, file, ...
        }
    }
}
