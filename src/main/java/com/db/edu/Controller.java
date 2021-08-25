package com.db.edu;

import static com.db.edu.Prefix.*;

public class Controller {

    private static long intResult;
    private static int byteResult;
    private static String stringResult;
    private static int stringCount;
    private static Object type;

    public void flush() {
        if (type == null) return;
        if (type instanceof Integer) {
            flushNum(Integer.MAX_VALUE, Integer.MIN_VALUE);
        } else if (type instanceof Byte) {
            flushNum(Byte.MAX_VALUE, Byte.MIN_VALUE);
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

    public void log(byte message) {
        if (!(type instanceof Byte)) {
            flush();
            type = message;
        }
        byteResult += message;
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

    private void flushNum(int maxValue, int minValue) {
        long numResult = maxValue == Byte.MAX_VALUE ? byteResult : intResult;
        while (numResult > maxValue) {
            numResult -= maxValue;
            ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + maxValue);
        }
        while (numResult < minValue) {
            numResult -= minValue;
            ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + minValue);
        }
        ConsoleSaver.writeMessage(PRIMITIVE_PREFIX.getMessage() + numResult);
        byteResult = 0;
        intResult = 0;
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
