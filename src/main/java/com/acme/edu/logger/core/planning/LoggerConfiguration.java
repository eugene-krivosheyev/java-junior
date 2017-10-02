package com.acme.edu.logger.core.planning;

/**
 * Simple log configuration.
 */
public class LoggerConfiguration {

    /** */
    private static LoggerConfiguration config = new LoggerConfiguration();

    /** */
    private static boolean logWithPrefixesAndPostfixes;

    /** */
    private static boolean logMessageTypesWillChanged;

    /** */
    private static boolean logMessageContentWillAccumulate;

    /** */
    private static boolean logMessageContentCheckOverflow;

    /** */
    private static boolean logWithCountTheStringDuplicates;

    /** */
    private static boolean logMessageTypesWillArrays;

    /** */
    private LoggerConfiguration() {}

    public boolean isLogWithPrefixesAndPostfixes() {
        return logWithPrefixesAndPostfixes;
    }

    public static void setLogWithPrefixesAndPostfixes(boolean confirmation) {
        logWithPrefixesAndPostfixes = confirmation;
    }

    public boolean isLogMessageTypesWillChanged() {
        return logMessageTypesWillChanged;
    }

    public static void setLogMessageTypesWillChanged(boolean confirmation) {
        logMessageTypesWillChanged = confirmation;
    }

    public boolean isLogMessageContentWillAccumulate() {
        return logMessageContentWillAccumulate;
    }

    public static void setLogMessageContentWillAccumulate(boolean confirmation) {
        logMessageContentWillAccumulate = confirmation;
    }

    public boolean isLogMessageContentCheckOverflow() {
        return logMessageContentCheckOverflow;
    }

    public static void setLogMessageContentCheckOverflow(boolean confirmation) {
        logMessageContentCheckOverflow = confirmation;
    }

    public boolean isLogWithCountTheStringDuplicates() {
        return logWithCountTheStringDuplicates;
    }

    public static void setLogWithCountTheStringDuplicates(boolean confirmation) {
        logWithCountTheStringDuplicates = confirmation;
    }

    public boolean isLogMessageTypesWillArrays() {
        return logMessageTypesWillArrays;
    }

    public static void setLogMessageTypesWillArrays(boolean confirmation) {
        logMessageTypesWillArrays = confirmation;
    }

    /**
     * Configure the logger configuration.
     * @return configuration.
     */
    public static LoggerConfiguration configure() {
        return config;
    }
}
