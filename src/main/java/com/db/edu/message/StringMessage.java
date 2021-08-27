package com.db.edu.message;

import static com.db.edu.message.Prefix.STRING_PREFIX;

public class StringMessage extends Message {

    private String stringResult;
    private int stringCount;

    public StringMessage(String message) {
        super(message);
        stringResult = message;
    }

    @Override
    public void flush() {
        saver.save(decorate(stringResult));
        stringResult = "";
        stringCount = 0;
    }

    @Override
    public StringMessage accumulate(Message message) {
        if (!sameTypeOf(message) || !message.getMessage().equals(stringResult)) {
            flush();
            return this;
        }
        stringResult = (String)message.getMessage();
        stringCount++;
        return this;
    }

    @Override
    public String decorate(Object message) {
        String strRes = STRING_PREFIX.body + message;
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        return strRes;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof StringMessage;
    }
}
