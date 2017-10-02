package com.acme.edu.logger2.core.message;

import com.acme.edu.logger2.core.format.LoggerFormatter;
import com.acme.edu.logger2.core.saver.LoggerSaver;

/**
 * Log entry.
 * Contains message content, type prefix,
 * reference to previous message,
 * reference to LoggerSaver and LoggerFormatter realisations.
 */
public abstract class Message {

    String content;
    private final String prefix;
    int counterOfStringDuplicates = 1;
    LoggerSaver loggerSaver;
    LoggerFormatter loggerFormatter;

    /**
     * Default constructor for all message realisations
     * @param prefix prefix for log entry
     * @param content entry content
     */
    Message(String prefix, String content) {
        this.prefix = prefix;
        this.content = content;
    }

    /**
     * Get content of message.
     * @return content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Set formatter and saver for message.
     * @param loggerSaver saver.
     * @param loggerFormatter formatter.
     * @return message.
     */
    public Message setFormatterAndSaver(LoggerSaver loggerSaver, LoggerFormatter loggerFormatter) {
        this.loggerFormatter = loggerFormatter;
        this.loggerSaver = loggerSaver;
        return this;
    }

    /**
     * Proceed message to formatter and saver realisations
     */
    void formatAndSave() {
        if (counterOfStringDuplicates > 1) {
            content = (content + " (x" + counterOfStringDuplicates + ")");
        }
        loggerFormatter.format(this);
        loggerSaver.save(this);
    }

    /**
     * Orders messages to process themselves
     */
    public void proceed(Message previousMessage) {
        previousMessage.formatAndSave();
    }

    /**
     * Modifies message content by adding prefix
     * as "prefix: " format.
     * Each of message realisations contains info about
     * their prefix.
     */
    public void addPrefix() {
        content = prefix + content;
    }

    /**
     * Check if specific message realisation
     * is instance of this Class
     * @param message Message realisation to compare
     * @return result of comparison
     */
    protected abstract boolean isSameClass(Message message);

    /**
     * Stop log.
     */
    public void stop() {
        this.formatAndSave();
    }
}

