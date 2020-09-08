package com.acme.edu.command;

public class StringMessage extends LoggerMessage implements  PrefixSupplier {
    private static int counter = 1;

    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        message += (counter > 1)?" (x" + counter + ")" + System.lineSeparator():"";
        return PREFIX_STRING + message;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return currentState instanceof StringMessage;
    }

    @Override
    public LoggerMessage accumulate(LoggerMessage newMessage) {
        final StringMessage finalNewMessage = (StringMessage) newMessage;
        if (message.contains(finalNewMessage.message)) {
            counter++;
        } else {
            message += (counter > 1)?" (x" + counter + ")" + System.lineSeparator():"";
            counter = 1;
            message = message + " " + finalNewMessage.message;
            //message = finalNewMessage.message;
        }
        return this;
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
