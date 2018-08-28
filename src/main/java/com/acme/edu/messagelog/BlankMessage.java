package com.acme.edu.messagelog;

public class BlankMessage extends Message {
    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return "";
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return true;
    }
}
