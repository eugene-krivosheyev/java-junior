package demo.ooad;


public class SeverityLevelLoggerFilter {
    private int severityLevelTreshold;

    public SeverityLevelLoggerFilter(int severityLevelTreshold) {
        this.severityLevelTreshold = severityLevelTreshold;
    }

    /**
     * @param level: 0 - Error, 1 - Warning, 2 - Debug
     */
    public boolean filter(LoggerMessage message) {
        return message.getSeverityLevel() < severityLevelTreshold;
    }
}
