package com.db.edu;

import static com.db.edu.ByteMessage.flushByte;
import static com.db.edu.IntMessage.flushInt;
import static com.db.edu.Prefix.*;

public class Controller {


    private static String stringResult;
    private static int stringCount;
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

    public void log(int message) {
        if (!(type instanceof Integer)) {
            flush();
            type = message;
        }
        intResult += message;
    }


    public void log(boolean message) {
        ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + message);
    }

    public void log(char message) {
        ConsoleSaver.writeMessage(CHAR_PREFIX.getMessage() + message);
    }

    public void log(String message) {
        if (!(type instanceof String)) {
            flush();
            type = message;
        } else if (!message.equals(stringResult)) {
            flush();
        }
        stringResult = message;
        stringCount++;
    }

    public void log(Object message) {
        ConsoleSaver.writeMessage(OBJECT_PREFIX.getMessage() + message);
    }

    public void log(int ... message) {
        for (int value : message) {
            log(value);
        }
        flush();
    }

    public void log(String ... message) {
        for (String value : message) {
            log(value);
        }
        flush();
    }

    private void flushString() {
        String strRes = STRING_PREFIX.getMessage() + stringResult;
        stringResult = "";
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        ConsoleSaver.writeMessage(strRes);
        stringCount = 0;
    }

}
