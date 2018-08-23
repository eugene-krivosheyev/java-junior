package ooaddemo;

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
