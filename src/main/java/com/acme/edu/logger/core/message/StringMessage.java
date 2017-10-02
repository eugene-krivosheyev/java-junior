package com.acme.edu.logger.core.message;

/**
 * Message with string content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class StringMessage {

    /** Message content. */
    private short content;

    /**
     * Constructor
     * @param content message content.
     */
    public StringMessage(short content) {
        this.content = content;
    }

    /**
     * Get message content.
     * @return message content.
     */
    public short getContent() {
        return content;
    }
}
