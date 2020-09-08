package com.acme.edu.command;

public class IntMessage extends LoggerMessage implements  PrefixSupplier {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX_PRIMITIVE + this.message;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return currentState instanceof IntMessage;
    }

    @Override
    public LoggerMessage accumulate(LoggerMessage newMessage) {
        final IntMessage finalNewMessage = (IntMessage) newMessage;
        message = message + finalNewMessage.message;
        return this;
    }
}


/*
    if (type.equals("")) {
        type = "int";
        int_buffer = message;
    } else {
        if ("int".equals(type) && (Integer.MAX_VALUE - int_buffer >= message)) {
            int_buffer += message;
        } else {
            chooseMessageWriter();
            type = "int";
            int_buffer = message;
        }
    }
    */

