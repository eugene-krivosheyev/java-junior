package com.acme.edu.message;

import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * Implementation of AbstractMessage for logging Strings.
 * Supports flushing with strings counter.
 * @see AbstractMessage
 */
public class StringMessage extends AbstractMessage {
    public String stringValue;
    private static final String PREFIX = "string: ";
    private static final String templateMultiple = PREFIX + "%s " + "(x%o)";
    private static final String templateUnique = PREFIX + "%s";

    public StringMessage(String message) {
        this.stringValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        String prevValue = ((StringMessage) listOfLog.get(0)).stringValue;
        int counter = 0;

        for (int i = 0; i < listOfLog.size(); i++) {
            String currentValue = ((StringMessage) listOfLog.get(i)).stringValue;
            if (i == listOfLog.size() - 1) {
                messageControllerUpdate(currentValue, counter);
            } else {
                if (currentValue.equals(prevValue)) {
                    counter += 1;
                } else {
                    messageControllerUpdate(prevValue, counter - 1);
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

    private void messageControllerUpdate(String value, int counter) {
        messageController
                .append(counter == 0 ?
                        String.format(templateUnique, value) :
                        String.format(templateMultiple, value, counter + 1))
                .append(lineSeparator());
    }
}
