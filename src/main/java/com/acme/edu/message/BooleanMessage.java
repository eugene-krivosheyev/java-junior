package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.utils.Saver;

public class BooleanMessage extends LoggerMessage{
    private boolean message;

    private boolean currentBooleanMessage = false;

    public BooleanMessage(boolean message) {
        super(MessageType.BOOLEAN, MessagePrefix.PRIMITIVE_PREFIX);
        this.message = message;
    }

    @Override
    public void accumulateMessage(LoggerMessage booleanMessage) {
        this.currentBooleanMessage = currentBooleanMessage || ((BooleanMessage) booleanMessage).getMessage();
    }

    @Override
    public String createMessageWithPrefix() {
        return referencePrefix.getPrefixString() + currentBooleanMessage;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public void printMessageBuffer(Saver saver) {
        saver.print(this.createMessageWithPrefix());
        this.currentBooleanMessage = false;
    }

    public boolean getMessage() {
        return message;
    }
}
