package com.acme.edu;

public class IntCommand implements LoggerMessage {
    public static final String PREFIX_PRIMITIVE = "primitive: ";

    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX_PRIMITIVE + this.message;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return currentState instanceof IntCommand;
    }

    @Override
    public void accumulate(LoggerMessage newMessage) {
        final IntCommand finalNewMessage = (IntCommand) newMessage;
        message = message + finalNewMessage.message;
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
}
