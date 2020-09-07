package demo.ooad;

/**
 * Package-friendly, package-local, default
 */
public class LoggerMessage {
    private String message;
    private int severityLevel;

    public LoggerMessage(String message, int severityLevel) {
        this.message = message;
        this.severityLevel = severityLevel;
    }

    public String getMessage() {
        return message;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }
}
