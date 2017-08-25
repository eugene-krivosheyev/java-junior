package com.acme.edu.ooad.loggerdemo;

public class Logger {
    private LoggerSaver saver =
            new ???LoggerSaverFactory().create(); //Abstract Factory [GoF]

    public void log(LoggerMessage message) {
        if (!message.filter()) { //Impl: content, severity, ...
            saver.save(message); //Impl: console, file, ...
        }
    }
}
