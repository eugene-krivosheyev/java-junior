package com.acme.edu.command;

/**
 * Interface for work with different message types
 */
public interface LoggerCommand {

    /**
     * @return decorated string according to type
     */
    String getDecoratedSelf();

    /**
     * Checks if it is time for flush
     * @param other - new incoming message
     * @return result of the check
     */
    boolean checkFlush(LoggerCommand other);

    /**
     * Accumulate current message with new one
     * @param other - new incoming message
     */
    void accumulate(LoggerCommand other);
}
