package demo.ooad.message;

import demo.ooad.SeverityLevel;

/**
 * Immutable POJO
 */
public abstract class LogSeverityMessage {
    private String message;
    private SeverityLevel severityLevel;

    public LogSeverityMessage(String message, SeverityLevel severityLevel) {
        this.message = message;
        this.severityLevel = severityLevel;
    }

    public String getMessage() {
        return message;
    }

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public abstract boolean filter(SeverityLevel minLevelForLogging);
}
