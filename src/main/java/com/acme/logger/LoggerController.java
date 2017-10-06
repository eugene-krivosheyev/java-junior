package com.acme.logger;

public class LoggerController {
    private LoggerSaver saver;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message) throws LoggingException {
        try {
            saver.save(message);
        } catch (SavingException e) {
            throw new LoggingException("{saving_error}", e);
        }
    }
}
