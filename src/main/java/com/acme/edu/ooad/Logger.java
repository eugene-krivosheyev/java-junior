package com.acme.edu.ooad;

import static com.acme.edu.ooad.HardCodedSaverFactory.create;

public class Logger {
    private LogMessageLengthFilter filter = new LogMessageLengthFilter(50);
    //Factory Method [GoF]
    private LogSaver saver = create();

    public void log(String message) {
        if (filter.allow(message)) {
            saver.save(message);
        }
    }
}
