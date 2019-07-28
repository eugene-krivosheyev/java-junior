package com.acme.edu;

import com.acme.edu.saver.Saver;

public class LoggerRegistry {
    public LoggerRegistry(Saver saver) {
        LoggerController theOnlyLogger = LoggerController.getTheOnlyLogger();
        theOnlyLogger.setSaver(saver);
    }

    public static LoggerController getLoggerController() {
        return LoggerController.getTheOnlyLogger();
    }
}
