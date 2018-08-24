package ooaddemo.filter;

import ooaddemo.controller.SeverityLevel;

/**
 * IS-A
 */
public class SeverityLevelLoggerFilter implements LoggerFilter {
    private SeverityLevel level;

    public SeverityLevelLoggerFilter(SeverityLevel level) {
        this.level = level;
    }

    @Override
    public boolean filter() {
        return level.ordinal() <= SeverityLevel.INFO.ordinal();
    }
}
