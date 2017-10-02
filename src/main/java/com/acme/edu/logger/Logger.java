package com.acme.edu.logger;

import com.acme.edu.logger.core.message.IntegerMessage;
import com.acme.edu.logger.core.planning.LoggerConfiguration;
import com.acme.edu.logger.core.planning.LoggerManager;

/**
 *  Simple logger program.
 */
public class Logger {

    /**
     * Active manager for logger.
     */
    private static LoggerManager manager = new LoggerManager();

    /**
     * Log of the message at char type.
     * @param message message.
     */
    public static void log(char message) {

    }

    /**
     * Log of the message at byte type.
     * @param message message.
     */
    public static void log(byte message) {

    }

    /**
     * Log of the message at short type.
     * @param message message.
     */
    public static void log(short message) {

    }

    /**
     * Log of the message at integer type.
     * @param message message.
     */
    public static void log(int message) {
        manager.getController().acceptMessage(new IntegerMessage(message));
    }

    /**
     * Log of the message at long type.
     * @param message message.
     */
    public static void log(long message) {

    }

    /**
     * Log of the message at boolean type.
     * @param message message
     */
    public static void log(boolean message) {

    }

    /**
     * Log of the message at string type.
     * @param message message.
     */
    public static void log(String message) {

    }

    /**
     * Log of the message at object type.
     * @param message message.
     */
    public static void log(Object message) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // CUSTOMS
    ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Log message content with prefixes and postfixes.
     */
    public static void logWithPrefixesAndPostfixes() {
        LoggerConfiguration.setLogWithPrefixesAndPostfixes(true);
    }

    /**
     * Log message types content will be changed.
     */
    public static void logMessageTypesWillChanged() {
        LoggerConfiguration.setLogMessageTypesWillChanged(true);
    }

    /**
     * Message content will be accumulate.
     */
    public static void logMessageContentWillAccumulate() {
        LoggerConfiguration.setLogMessageContentWillAccumulate(true);
    }

    /**
     * Message content will be checks at overflow.
     */
    public static void logMessageContentCheckOverflow() {
        LoggerConfiguration.setLogMessageContentCheckOverflow(true);
    }

    /**
     * Count the string message duplicates.
     */
    public static void logWithCountTheStringDuplicates() {
        LoggerConfiguration.setLogWithCountTheStringDuplicates(true);
    }

    /**
     * Log message types will be arrays.
     */
    public static void logMessageTypesWillArrays() {
        LoggerConfiguration.setLogMessageTypesWillArrays(true);
    }

    /**
     * Start the log.
     */
    public static void start() {
        manager.getController().setConfig(LoggerConfiguration.configure());
        manager.getController().start();
    }

    /** Stop the log. */
    public static void stop() {
        manager.getController().stop();
    }

    /**
     * Output of the logger complete work.
     */
    public static void out() {
        System.out.printf("%s", manager.getCompleteOutput());
    }
}
