package com.acme.edu.logger.core.message;

/**
 * Message with char primitive content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class CharMessage {

    /** Message content. */
    private short content;

    /**
     * Constructor
     * @param content message content.
     */
    public CharMessage(short content) {
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
