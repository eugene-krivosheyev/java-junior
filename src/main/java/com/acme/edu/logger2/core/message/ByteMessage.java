package com.acme.edu.logger2.core.message;

/**
 * Byte message realisation.
 * Tots up byte values and checks the results for overflow.
 */
public class ByteMessage extends NumericMessage implements MessagePrefix {
    /**
     * Message that contains byte value as string
     * @param message byte value
     */
    public ByteMessage(byte message) {
        super(PREFIX_PRIMITIVE, Byte.toString(message), Byte.MAX_VALUE);
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof ByteMessage;
    }
}
