package com.acme.edu;

public class ObjectCommand implements LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }

    @Override
    public void accumulate(LoggerMessage newMessage) {

    }
    /*chooseMessageWriter();
    writeMessage(PREFIX_REFERENCE + message);
    type = "";*/
}
