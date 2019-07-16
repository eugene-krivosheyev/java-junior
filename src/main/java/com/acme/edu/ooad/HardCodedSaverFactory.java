package com.acme.edu.ooad;

public class HardCodedSaverFactory implements SaverFactory {
    public LogSaver create() {
        return new LogConsoleSaver();
    }
}
