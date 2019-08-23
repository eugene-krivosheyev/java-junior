package com.acme.edu.ooaddemo2;

public class IntCommand implements Command {
    private int severity;
    private int message;

    public IntCommand(int message, int severity) {
        this.severity = severity;
        this.message = message;
    }

    @Override
    public int getSeverity() {
        return severity;
    }

    @Override
    public String getDecorated() {
        return "primitive: " + message;
    }
}
