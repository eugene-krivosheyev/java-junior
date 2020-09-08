package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging Chars.
 * @see AbstractMessage
 */
public class CharMessage extends AbstractMessage{
    public CharMessage(char message) {
        PREFIX = "char: ";
        messageController.setLength(0);
        messageController
                .append(PREFIX)
                .append(message);
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {};

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof CharMessage;
    }
}
