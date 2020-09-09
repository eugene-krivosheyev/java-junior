package com.acme.edu.message;

import com.acme.edu.saver.Saver;

/**
 * Class that represents input message of type String
 */
public class StringMessage implements LoggerMessage{
    private String message;
    private final String REFERENCE_PREFIX = "string: ";

    private static String currentStringMessage = "";
    private static String lastStringMessage = "";
    private static int sameStringAmount = 0;

    public StringMessage(String message) {
        this.message = message;
    }

    /**
     * Accumulate current massage content with previous  message
     * For same Strings increase amount of same lines
     *
     * @param message
     */
    @Override
    public void accumulateMessage(LoggerMessage message) {
        lastStringMessage = ((StringMessage) message).getMessage();
        currentStringMessage = ((StringMessage) message).getMessage();
        sameStringAmount++;
    }

    /**
     * Decorate accumulated message
     * Save accumulated message
     *
     * @param saver
     */
    @Override
    public void printMessageBuffer(Saver saver) {
        if ("".equals(currentStringMessage)) return;
        saver.print(this.createMessageWithPrefix());
        currentStringMessage = "";
        lastStringMessage = "";
        sameStringAmount = 0;
    }

    /**
     * Check if message type is the same as the previous message type
     *
     * @param message
     * @return boolean result
     */
    @Override
    public boolean isSameType(LoggerMessage message) {
        return (message instanceof StringMessage) && ((StringMessage) message).getMessage().equals(lastStringMessage);
    }

    /**
     * Create decorated message with prefixes
     *
     * @return String decoratedMessage
     */
    @Override
    public String createMessageWithPrefix() {
        if (sameStringAmount != 1) {
            currentStringMessage += " (x"+ sameStringAmount + ")";
        }
        return REFERENCE_PREFIX + currentStringMessage;
    }

    public String getMessage() {
        return message;
    }
}
