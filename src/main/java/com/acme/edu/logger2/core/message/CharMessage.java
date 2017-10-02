package com.acme.edu.logger2.core.message;

/**
 * Char type message realisation.
 * Contains char data as string.
 */
public class CharMessage extends Message implements MessagePrefix {
    /**
     * Message that contains char as String
     * @param message char value
     */
    public CharMessage(char message) {
        super(PREFIX_CHAR, Character.toString(message));
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof CharMessage;
    }
}
