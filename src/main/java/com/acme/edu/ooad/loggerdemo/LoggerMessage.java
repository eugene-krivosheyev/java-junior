package com.acme.edu.ooad.loggerdemo;

public class LoggerMessage {
    private String message;

    public LoggerMessage(String message) {
        this.message = message;
    }

    public boolean filter() {
        return false;
    }
}
