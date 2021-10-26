package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public abstract class NumberMessage implements Message{
    protected abstract long getValue();
    protected abstract void setValue(long value);
    protected abstract long getMaxValue();

    @Override
    public abstract Message clone();

    @Override
    public Message accumulate(Message message) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate messages with different types");
        }
        NumberMessage previousMessage = null;
        NumberMessage newMessage = (NumberMessage) message;
        if (getValue() + newMessage.getValue() > getMaxValue()) {
            previousMessage = createNumberMessage(getMaxValue());
            setValue(getValue() + newMessage.getValue() - getMaxValue());
        }
        else {
            setValue(getValue() + newMessage.getValue());
        }
        return previousMessage;
    }

    protected abstract NumberMessage createNumberMessage(long value);
}
