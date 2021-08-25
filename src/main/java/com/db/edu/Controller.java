package com.db.edu;

import static com.db.edu.ByteMessage.flushByte;
import static com.db.edu.IntMessage.flushInt;
import static com.db.edu.Prefix.*;
import static com.db.edu.StringMessage.flushString;

public class Controller {

    private static Object type;

    public static void flush() {
        if (type == null) return;
        if (type instanceof Integer) {
            flushInt();
        } else if (type instanceof Byte) {
            flushByte();
        } else if (type instanceof String) {
            flushString();
        }
    }

    public void log(IntMessage message) {
       type = message.accumulate(type);
    }

    public void log(ByteMessage message) {
        type = message.accumulate(type);
    }

    public void log(StringMessage message) {
        type = message.accumulate(type);
    }

    public void log(boolean message) {
        ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + message);
    }

    public void log(char message) {
        ConsoleSaver.writeMessage(CHAR_PREFIX.getMessage() + message);
    }

    public void log(Object message) {
        ConsoleSaver.writeMessage(OBJECT_PREFIX.getMessage() + message);
    }

    public void log(int ... message) {
        for (int value : message) {
            log(new IntMessage(value));
        }
        flush();
    }

    public void log(String ... message) {
        for (String value : message) {
            log(new StringMessage(value));
        }
        flush();
    }

}
