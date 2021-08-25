package com.db.edu.message;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.STRING_PREFIX;

public class StringMessage implements Message {
    private static String stringResult;
    private static int stringCount;
    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    public Object accumulate(Object type) {
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

    public static void flushString() {
        String strRes = STRING_PREFIX.getMessage() + stringResult;
        stringResult = "";
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        saver.save(strRes);
        stringCount = 0;
    }
}
