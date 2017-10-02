package com.acme.edu.logger2.core.message;

/**
 * Integer message realisation.
 * Tots up int values and checks the results for overflow.
 */
public class IntMessage extends NumericMessage implements MessagePrefix {

    /**
     * Message that contains integer value as string
     * @param message int value
     */
    public IntMessage(int message) {
        super(PREFIX_PRIMITIVE, Integer.toString(message), Integer.MAX_VALUE);
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof IntMessage;
    }
}
