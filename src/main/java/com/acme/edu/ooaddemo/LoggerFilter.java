package com.acme.edu.ooaddemo;

public interface LoggerFilter {
    boolean isFiltered(String message, int severityLevel);
}
