package demo.ooad;

public class SeverityLevelLoggerFilter {
    private int severityLevelTreshold;
    private int level;

    public SeverityLevelLoggerFilter(int severityLevelTreshold) {
        this.severityLevelTreshold = severityLevelTreshold;
    }

    /**
     * @param level: 0 - Error, 1 - Warning, 2 - Debug
     */
    public boolean filter(String message) {
        return level < severityLevelTreshold;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
