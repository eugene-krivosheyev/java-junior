package com.acme.edu.logger2.core.message;

abstract class NumericMessage extends Message {
    private int maxValue;
    /**
     * Class numeric of messages, such as byte and integer
     * @param prefix prefix for log entry
     * @param content numeric value
     */
    NumericMessage(String prefix, String content, int maxValue) {
        super(prefix, content);
        this.maxValue = maxValue;
    }

    @Override
    public void proceed(Message previousMessage) {
        if (isSameClass(previousMessage)) {
            addPreviousValueAndCheckForOverflow(previousMessage.content, maxValue);
        } else {
            super.proceed(previousMessage);
        }
    }

    /**
     * Method that performs addition of primitive integer values.
     * Also controls results for overflow.
     * @param content previous message int value as string.
     */
    private void addPreviousValueAndCheckForOverflow(String content, int maxValue) {
        int currentInput = Integer.parseInt(this.content);
        int previousInput = Integer.parseInt(content);
        if (maxValue - previousInput < currentInput) {
            currentInput -= (maxValue - previousInput);
            new IntMessage(currentInput).setFormatterAndSaver(loggerSaver,
                    loggerFormatter).formatAndSave();
            this.content = Integer.toString(maxValue);
        } else {
            this.content = Integer.toString(previousInput + currentInput);
        }
    }
}
