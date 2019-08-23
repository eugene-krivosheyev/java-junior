package com.acme.edu.ooaddemo2;

public class StringCommand implements Command {
    private String message;
    private int severity;

    public StringCommand(String message, int severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int getSeverity() {
        return severity;
    }

    @Override
    public String getDecorated() {
        return "string: " + message;
    }
}
