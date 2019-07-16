package com.acme.edu.ooad;

public class Logger {
    private LogMessageLengthFilter filter = new LogMessageLengthFilter(50);
    //Creator [GRASP]
    private LogSaver saver = new LogFileSaver("log.txt");

    public void log(String message) {
        if (filter.allow(message)) {
            saver.save(message);
        }
    }
}
