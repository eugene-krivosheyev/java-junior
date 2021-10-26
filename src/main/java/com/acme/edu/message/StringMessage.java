package com.acme.edu.message;

import com.acme.edu.exception.IllegalMessageStateException;

public class StringMessage implements Message {

    private static final String STRING_PREFIX = "string: ";

    private String preBody = "";
    private String stringBuffer = "";
    private int stringCount;

    public StringMessage(String str) {
        stringBuffer = str;
        stringCount++;
    }

    @Override
    public Message append(Message message) {
        if (!(message instanceof StringMessage)) throw new IllegalMessageStateException("Expected StringMessage type");
        StringMessage stringMessage = (StringMessage) message;

        if (!stringBuffer.equals(stringMessage.stringBuffer)) {
            preBody += getDecoratedString();
            stringBuffer = stringMessage.stringBuffer;
            stringCount = 0;
        }
        stringCount++;
        return this;
    }

    @Override
    public String getBody() {
        return preBody + getDecoratedString();
    }

    @Override
    public boolean canAppend(Message message) {
        return message instanceof StringMessage;
    }

    private String getDecoratedString() {
        String result = STRING_PREFIX + stringBuffer;
        if (stringCount > 1) {
            result += " (x" + stringCount + ")";
        }
        return result + System.lineSeparator();
    }
}
