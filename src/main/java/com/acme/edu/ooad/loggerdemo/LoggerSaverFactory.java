package com.acme.edu.ooad.loggerdemo;

public class LoggerSaverFactory { //XML, JSON, DB, USER
    public static LoggerSaver create() {
        return new ConsoleSaver();
    }
}
