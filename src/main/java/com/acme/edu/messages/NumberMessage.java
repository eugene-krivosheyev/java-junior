package com.acme.edu.messages;

import com.acme.edu.common.Message;

public abstract class NumberMessage implements Message{
    @Override
    public Message accumulate(Message message) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate messages with different types");
        }
        NumberMessage newMessage = null;
        NumberMessage numberMessage = (NumberMessage) message;
        if (getValue() + numberMessage.getValue() > getMaxValue()) {
            newMessage = createNumberMessage(getValue() + numberMessage.getValue() - getMaxValue());
            setValue(getMaxValue());
        }
        else {
            setValue(getValue() + numberMessage.getValue());
        }
        return newMessage;
    }

    protected abstract long getValue();
    protected abstract void setValue(long value);
    protected abstract long getMaxValue();
    protected abstract NumberMessage createNumberMessage(long value);
}
