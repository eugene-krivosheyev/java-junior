package demo.ooad;


public class SeverityLevelLoggerFilter extends NullCheckLoggerFilter implements LoggerFilter {
    private int severityLevelTreshold;

    public SeverityLevelLoggerFilter(int severityLevelTreshold) {
        this.severityLevelTreshold = severityLevelTreshold;
    }

    /**
     * @param message: 0 - Error, 1 - Warning, 2 - Debug
     */
    public boolean filter(LoggerMessage message) {
        checkNull(message);

        return message.getSeverityLevel() < severityLevelTreshold;
    }
}
