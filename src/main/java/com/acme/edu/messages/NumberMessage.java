package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public abstract class NumberMessage implements Message{
    protected abstract long getValue();
    protected abstract void setValue(long value);
    protected abstract long getMaxValue();
    public void accumulate(Message message, Printer printer) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate messages with different types");
        }
        NumberMessage newMessage = (NumberMessage) message;
        if (getValue() + newMessage.getValue() > getMaxValue()) {
            // TODO fix overflow logic
            printer.print(this);
            setValue(getMaxValue());
            printer.print(this);
        }
        setValue(getValue() + newMessage.getValue());
    }
}
