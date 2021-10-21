package com.acme.edu.message;

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
        if (!canAppend(message)) throw new IllegalArgumentException("Expected StringMessage type");
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
        if (stringCount == 1) {
            return STRING_PREFIX + stringBuffer + System.lineSeparator();
        } else {
            return STRING_PREFIX + stringBuffer + " (x"+ stringCount + ")" + System.lineSeparator();
        }
    }
}
