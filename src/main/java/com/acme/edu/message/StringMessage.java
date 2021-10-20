package com.acme.edu.message;

public class StringMessage extends Message {

    private static final String STRING_PREFIX = "string: ";

    private String stringBuffer = "";
    private int stringCount;

    public StringMessage(String str) {
        super(Type.STRING);
        stringBuffer = str;
        stringCount++;
        changeBody();
    }

    public void addToMessage(StringMessage message) {
        addString(message.stringBuffer);
    }

    public void addString(String str) {
        if (stringBuffer == null) {
            stringBuffer = str;
            stringCount++;
            return;
        }
        if (!str.equals(stringBuffer)) {
            stringBuffer = str;
            stringCount = 0;
            changeBody();
        }
        stringCount++;
    }

    private void changeBody() {
        body += STRING_PREFIX + stringBuffer + System.lineSeparator();
    }
}
