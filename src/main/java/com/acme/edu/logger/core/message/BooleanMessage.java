package com.acme.edu.logger.core.message;

/**
 * Message with boolean primitive content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class BooleanMessage extends Message {

    /** */
    private boolean content;

    /** */
    public BooleanMessage(boolean content) {
        super();
    }

    /** */
    public boolean getContent() {
        return content;
    }
}
