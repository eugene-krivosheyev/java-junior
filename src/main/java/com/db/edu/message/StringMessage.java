package com.db.edu.message;

import java.util.Objects;

import static com.db.edu.message.Prefix.STRING_PREFIX;

public class StringMessage extends Message {
    private String stringResult;
    private int stringCount;

    public StringMessage(String message) {
        super(message);
        this.stringResult = message;
        this.stringCount = 1;
    }

    @Override
    public StringMessage accumulate(Message message) {
        if (!sameTypeOf(message) || !message.getMessage().equals(stringResult)) {
            flush();
            return this;
        }
        if (message.getMessage().equals(stringResult)) {
            stringResult = (String) message.getMessage();
            stringCount++;
        }
        return this;
    }

    @Override
    public String decorate() {
        String strRes = STRING_PREFIX.body + stringResult;
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        return strRes;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return accumulateMessage instanceof StringMessage && Objects.equals(this.getMessage(), accumulateMessage.getMessage());
    }

    @Override
    public Object getMessage() {
        return this.stringResult;
    }

    private void flush() {
        stringResult = "";
        stringCount = 1;
    }
}
