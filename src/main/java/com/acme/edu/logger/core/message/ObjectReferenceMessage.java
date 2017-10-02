package com.acme.edu.logger.core.message;

/**
 * Message with object reference content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class ObjectReferenceMessage {

    /** Message content. */
    private short content;

    /**
     * Constructor
     * @param content message content.
     */
    public ObjectReferenceMessage(short content) {
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
