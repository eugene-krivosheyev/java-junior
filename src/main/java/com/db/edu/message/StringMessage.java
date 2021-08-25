package com.db.edu.message;

import static com.db.edu.Controller.flush;
import static com.db.edu.Prefix.STRING_PREFIX;

public class StringMessage extends Message<String> {
    private static String stringResult;
    private static int stringCount;

    public StringMessage(String message) {
        this.message = message;
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

    @Override
    public StringMessage accumulate(Message message) {
        if (!(message instanceof StringMessage) || !message.getMessage().equals(stringResult)) {
            flush();
        }
        stringResult = (String) message.getMessage();
        stringCount++;
        return this;
    }
}
