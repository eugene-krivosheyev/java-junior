package com.acme.edu.command;

public class ByteMessage extends LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}



    /*if (type.equals("")) {
        type = "byte";
        byte_buffer = message;
    } else {
        if ("byte".equals(type) && (Byte.MAX_VALUE - byte_buffer >= message)) {
            byte_buffer += message;
        } else {
            chooseMessageWriter();
            type = "byte";
            byte_buffer = message;
        }
    }*/

