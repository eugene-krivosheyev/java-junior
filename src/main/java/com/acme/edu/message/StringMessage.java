package com.acme.edu.message;

import java.util.ArrayList;

import static java.lang.System.lineSeparator;

/**
 * Implementation of AbstractMessage for logging Strings.
 * Supports flushing with strings counter.
 * @see AbstractMessage
 */
public class StringMessage extends AbstractMessage {
    public String stringValue;
    private static final String PREFIX = "string: ";

    public StringMessage(String message) {
        this.stringValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        String templateMultiple = PREFIX + "%s " + "(x%o)";
        String templateUnique = PREFIX + "%s";
        String prevValue = ((StringMessage) listOfLog.get(0)).stringValue;
        int counter = 0;

        for (int i = 0; i < listOfLog.size(); i++) {
            String currentValue = ((StringMessage) listOfLog.get(i)).stringValue;
            if (i == listOfLog.size() - 1) {
                messageController
                        .append(counter == 0 ?
                                String.format(templateUnique, currentValue) :
                                String.format(templateMultiple, currentValue, counter + 1))
                        .append(lineSeparator());
            } else {
                if (currentValue.equals(prevValue)) {
                    counter += 1;
                } else {
                    messageController
                            .append(counter == 1 ?
                                    String.format(templateUnique, prevValue) :
                                    String.format(templateMultiple, prevValue, counter))
                            .append(lineSeparator());
                }
                prevValue = currentValue;
            }
        }
        messageController.delete(messageController.length() - 2, messageController.length());
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof StringMessage;
    }
}
