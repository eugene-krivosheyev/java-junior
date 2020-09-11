package com.acme.edu.message;

import java.util.List;

/**
 * Implementation of AbstractMessage for logging Chars.
 * @see AbstractMessage
 */
public class CharMessage extends AbstractMessage{
    protected char charValue;
    private static final String PREFIX = "char: ";

    public CharMessage(char message) {
        this.charValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        char preparedCharValue = ((CharMessage) listOfLog.get(0)).charValue;
        messageController.append(PREFIX).append(preparedCharValue);
    };

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof CharMessage;
    }
}
