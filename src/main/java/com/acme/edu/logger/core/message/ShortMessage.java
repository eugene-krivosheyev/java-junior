package com.acme.edu.logger.core.message;


/**
 * Message with short primitive content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class ShortMessage extends Message {

    /** Message content. */
    private short content;

    /**
     * Constructor
     * @param content message content.
     */
    public ShortMessage(short content) {
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
