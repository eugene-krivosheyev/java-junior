package com.acme.edu.message;

public class StringMessage implements Message {

    private static final String STRING_PREFIX = "string: ";

    private String stringBuffer = "";
    private int stringCount;

    public StringMessage(String str) {
        stringBuffer = str;
        stringCount++;
    }

    @Override
    public Message append(Message message) {
        String str = "";
        if (stringBuffer == null) {
            stringBuffer = str;
            stringCount++;
            return this;
        }
        if (!str.equals(stringBuffer)) {
            stringBuffer = str;
            stringCount = 0;
        }
        stringCount++;
        return this;
    }

    @Override
    public String getBody() {
        String body = STRING_PREFIX + stringBuffer + System.lineSeparator();
        return body;
    }

    @Override
    public boolean canAppend(Message message) {
        return false;
    }
}
