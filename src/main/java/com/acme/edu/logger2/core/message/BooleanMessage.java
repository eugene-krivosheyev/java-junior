package com.acme.edu.logger2.core.message;

/**
 * Boolean type message realisation.
 * Contains boolean value as string.
 */
public class BooleanMessage extends Message implements MessagePrefix {
    /**
     * Message that contains boolean value as string
     * @param message boolean value
     */
    public BooleanMessage(boolean message) {
        super(PREFIX_PRIMITIVE, Boolean.toString(message));
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof BooleanMessage;
    }
}
