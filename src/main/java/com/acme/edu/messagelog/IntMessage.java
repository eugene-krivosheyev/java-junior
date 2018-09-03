package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.OverflowAccumulationException;

public class IntMessage extends Message<Integer> {
    private static final String TYPE_NAME = "primitive";

    public IntMessage(int message) {
        this.value = message;
        type = TYPE_NAME;
    }

    @Override
    public Message accumulate(Message message) throws OverflowAccumulationException {
        if (isOverflow(((IntMessage) message).value)) throw new OverflowAccumulationException("Integer is overflowed!");
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
        return super.canBeAccumulated(message);
    }

    private boolean isOverflow(int term) {
        return (term > 0 && value > Integer.MAX_VALUE - term) ||
                (term < 0 && value < Integer.MIN_VALUE - term);
    }
}
