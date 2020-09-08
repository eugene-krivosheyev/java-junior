package com.acme.edu;

public class StringCommand extends LoggerMessage {
    public static final String PREFIX_STRING = "string: ";

    private static int counter = 1;

    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX_STRING + message;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return currentState instanceof StringCommand;
    }

    @Override
    public void accumulate(LoggerMessage newMessage) {
        if (message.equals(newMessage.message)) {
            counter++;
        } else {
            message += " (x" + counter + ")" + System.lineSeparator();
            counter = 0;
            final StringCommand finalNewMessage = (StringCommand) newMessage;
            message = message + finalNewMessage.message;
            message = newMessage.message;
        }
    }


    /*if (type.equals("")) {
        type = "string";
        string_buffer = message;
    } else {
        if ("string".equals(type)) {
            if(string_buffer.equals(message)){
                counter++;
            }
            else {
                chooseMessageWriter();
                string_buffer = message;
            }
        } else {
            chooseMessageWriter();
            type = "string";
            string_buffer = message;
        }
    }*/
}
