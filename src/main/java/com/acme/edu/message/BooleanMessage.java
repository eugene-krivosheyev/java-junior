package com.acme.edu.message;

public class BooleanMessage extends LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}


/*chooseMessageWriter();
    writeMessage(PREFIX_PRIMITIVE + message);
    type = "";*/