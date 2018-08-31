package com.acme.edu.messagelog;

public class IntMessage extends Message<Integer> {
    private static final String TYPE_NAME = "primitive";

    public IntMessage(int message) {
        this.value = message;
        type = TYPE_NAME;
    }

    @Override
    public Message accumulate(Message message) {
        IntMessage newMessage = (IntMessage) message;
        int newValue = value + newMessage.value;
        return new IntMessage(newValue);
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message) && !isOverflow(((IntMessage) message).value);
    }
/*
    private void isOverflow(int term) throws OverflowException {
        if ((term > 0 && value > Integer.MAX_VALUE - term) ||
                (term < 0 && value < Integer.MIN_VALUE - term)) {
            throw new OverflowException("Overflow int type when tried to sum " + value + " with " + value);
        };
    }
    */

    private boolean isOverflow(int term) {
        return (term > 0 && value > Integer.MAX_VALUE - term) ||
                (term < 0 && value < Integer.MIN_VALUE - term);
    }
}
