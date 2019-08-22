package com.acme.edu.ooaddemo;

public interface LoggerFilter {
    /** Abstraction Leak
     * for arguments:
     * @param message
     * @param severityLevel
     */
    boolean isFiltered(String message, int severityLevel);
}
