package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.saver.Saver;

public class ObjectMessage extends LoggerMessage{
    private Object message;

    private Object currentObjectMessage = null;

    public ObjectMessage(Object message) {
        super(MessageType.OBJECT, MessagePrefix.REFERENCE_PREFIX);
        this.message = message;
    }

    @Override
    public void accumulateMessage(LoggerMessage objectMessage) {
        this.currentObjectMessage = ((ObjectMessage) objectMessage).getMessage();
    }

    @Override
    public String createMessageWithPrefix() {
        return referencePrefix.getPrefixString() + currentObjectMessage;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public void printMessageBuffer(Saver saver) {
        saver.print(this.createMessageWithPrefix());
        this.currentObjectMessage = null;
    }

    public Object getMessage() {
        return message;
    }
}
