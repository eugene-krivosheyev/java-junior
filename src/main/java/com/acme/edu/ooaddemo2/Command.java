package com.acme.edu.ooaddemo2;

public class Command {
    private String message;
    private int severity;

    public Command(String message, int severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public int getSeverity() {
        return severity;
    }
}
