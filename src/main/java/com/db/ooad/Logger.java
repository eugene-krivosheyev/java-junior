package com.db.ooad;

public class Logger {

    private LoggerSaver loggerSaver;
    private LoggerFilter loggerFilter;

    Logger(LoggerFilter lf, LoggerSaver svr) {
        loggerFilter = lf;
        loggerSaver = svr;

    }

    public void log(final String message) {
        if (loggerFilter.filter(message)) {
            loggerSaver.save(message);
        }
    }
}
