package com.db.edu;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.STRING_PREFIX;

public class StringMessage {
    private static String stringResult;
    private static int stringCount;
    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    Object accumulate(Object type) {
        if (!(type instanceof String)) {
            flush();
            type = message;
        } else if (!message.equals(stringResult)) {
            flush();
        }
        stringResult = message;
        stringCount++;
        return type;
    }

    static void flushString() {
        String strRes = STRING_PREFIX.getMessage() + stringResult;
        stringResult = "";
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        ConsoleSaver.writeMessage(strRes);
        stringCount = 0;
    }
}
