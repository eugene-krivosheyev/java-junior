package com.acme.edu.ooad;

public class HardCodedSaverFactory {
    public static LogSaver create() {
        return new LogConsoleSaver();
    }
}
