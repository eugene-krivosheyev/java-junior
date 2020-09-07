package com.acme.edu;

public class LoggerController {
    private LoggerSaver saver;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        saver.save(message.getMessage());
    }
}
