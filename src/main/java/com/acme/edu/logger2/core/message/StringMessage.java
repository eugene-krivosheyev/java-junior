package com.acme.edu.logger2.core.message;

/**
 * Message realisation that contains and processes strings.
 */
public class StringMessage extends Message implements MessagePrefix {
    /**
     * Message that contains a string
     * @param message some string
     */
    public StringMessage(String message) {
        super(PREFIX_STRING, message);
    }

    @Override
    public void proceed(Message previousMessage) {
        if (isSameClass(previousMessage)) {
            checkIfPreviousStringIsEqualOrNot(previousMessage.content, previousMessage);
        } else {
            super.proceed(previousMessage);
        }
    }

    /**
     * Method that checks previous if current message content is equal to previous.
     * After checking, method can increase the duplicate counter.
     * @param oldString previous message content.
     */
    private void checkIfPreviousStringIsEqualOrNot(String oldString, Message previousMessage) {
        if (oldString.equals(content)) {
            counterOfStringDuplicates = previousMessage.counterOfStringDuplicates + 1;
        } else {
            super.proceed(previousMessage);
        }
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof StringMessage;
    }
}
