package com.acme.edu.logger.core.message;

/**
 * Message with byte primitive content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class ByteMessage extends Message {

    /** Message content. */
    private byte content;

    /**
     * Constructor
     * @param content message content.
     */
    public ByteMessage(byte content) {
        this.content = content;
    }
}
