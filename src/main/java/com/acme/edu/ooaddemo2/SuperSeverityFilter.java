package com.acme.edu.ooaddemo2;

public class SuperSeverityFilter implements SuperFilter {
    private final int MAX_SEVERITY;

    public SuperSeverityFilter(int maxSeverity) {
        this.MAX_SEVERITY = maxSeverity;
    }

    @Override
    public boolean isFiltered(Command command) {
        return command.getSeverity() < MAX_SEVERITY;
    }
}
