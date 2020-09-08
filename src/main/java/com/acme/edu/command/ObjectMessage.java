package com.acme.edu.command;

public class ObjectMessage extends LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }

    /*chooseMessageWriter();
    writeMessage(PREFIX_REFERENCE + message);
    type = "";*/
}
