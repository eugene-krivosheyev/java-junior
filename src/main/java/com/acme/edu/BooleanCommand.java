package com.acme.edu;

public class BooleanCommand implements LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }

    /*chooseMessageWriter();
        writeMessage(PREFIX_PRIMITIVE + message);
        type = "";*/
    public void accumulate(LoggerMessage message) {

    }
}
