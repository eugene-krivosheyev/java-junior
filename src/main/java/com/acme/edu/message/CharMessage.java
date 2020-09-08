package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging Chars.
 * @see AbstractMessage
 */
public class CharMessage extends AbstractMessage{
    protected char charValue;
    private static final String PREFIX = "char: ";

    public CharMessage(char message) {
        charValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        messageController
                .append(PREFIX)
                .append(((CharMessage)listOfLog.get(0)).charValue);
    };

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof CharMessage;
    }
}
