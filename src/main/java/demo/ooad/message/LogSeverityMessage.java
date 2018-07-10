package demo.ooad.message;

import demo.ooad.SeverityLevel;

/**
 * Immutable POJO
 */
public abstract class LogSeverityMessage {
    /**
     * Visibility modifiers:
     * - public
     * - protected: visibility for subclasses
     * - "default" | "package-friendly"
     * - private
     */

    /**
     * OCP:
     * Client {
     * LMS message;
     * message.getMessage();
     * }
     */
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

    public abstract boolean compareTo(SeverityLevel minLevelForLogging);
}


class Girl {
    private int age;


    public int getAge() {
        return 15;
    }
}
