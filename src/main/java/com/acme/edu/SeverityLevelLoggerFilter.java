package com.acme.edu;

public class SeverityLevelLoggerFilter implements LoggerFilter {
    @Override
    public boolean filter(int message) {
        return true;
    }
}
