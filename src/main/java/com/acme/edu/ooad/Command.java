package com.acme.edu.ooad;

public class Command {
    private String message;
    private int severityLevel;

    public Command(String message, int severityLevel) {
        this.message = message;
        this.severityLevel = severityLevel;
    }

    public String getMessage() {
        return message;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public boolean isAllowed(int max_level) {
        return this.severityLevel > max_level;
    }
}
