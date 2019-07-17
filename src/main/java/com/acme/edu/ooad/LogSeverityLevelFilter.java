package com.acme.edu.ooad;

public class LogSeverityLevelFilter implements LogFilter {
    private final int MAX_LEVEL;

    public LogSeverityLevelFilter(int maxLevel) {
        MAX_LEVEL = maxLevel;
    }

    @Override
    public boolean allow(Command message) {
        return message.isAllowed(MAX_LEVEL);
    }
}
