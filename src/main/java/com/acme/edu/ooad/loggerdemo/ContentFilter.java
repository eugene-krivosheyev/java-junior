package com.acme.edu.ooad.loggerdemo;

public class ContentFilter implements LoggerFilter {
    @Override
    public boolean filter(String message) {
        return false;
    }
}
