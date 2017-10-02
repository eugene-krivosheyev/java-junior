package com.acme.edu.logger.core.message;

/**
 * Message with integer primitive content type.
 *
 * @author Donatio Nikolashin.
 * @author Timur Kashapov.
 * @since 0.0.1
 */
public class IntegerMessage extends Message {

    /** */
    protected int content;

    /** */
    public IntegerMessage(int content) {
        super();
    }

    /** */
    protected int getContent() {
        return content;
    }
}
