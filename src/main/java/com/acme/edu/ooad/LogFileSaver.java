package com.acme.edu.ooad;

public class LogFileSaver implements LogSaver {
    private String filename;

    public LogFileSaver(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(Command message) {

    }
}
