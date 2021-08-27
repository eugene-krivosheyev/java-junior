package com.db.edu.message;

import static com.db.edu.Prefix.STRING_PREFIX;

public class StringMessage extends Message {

    private final String message;
    private String stringResult;
    private int stringCount;

    public StringMessage(String message) {
        super(message);
        this.message = message;
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
        if (!(message instanceof StringMessage) || !message.getMessage().equals(stringResult)) {
            flush();
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
