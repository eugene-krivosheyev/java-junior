package com.acme.edu.message;

import com.acme.edu.exception.IllegalMessageStateException;

public class StringMessage implements Message {

    protected static final String STRING_PREFIX = "string: ";

    private final String stringBuffer;
    private int stringCount;

    public StringMessage(String str) {
        stringBuffer = str;
        stringCount++;
    }

    public StringMessage(String str, int strCount) {
        stringBuffer = str;
        stringCount = strCount;
    }

    public StringMessage(StringMessage message) {
        stringBuffer = message.stringBuffer;
        stringCount = message.stringCount;
    }

    @Override
    public Message[] append(Message message) {
        if (!(message instanceof StringMessage)) throw new IllegalMessageStateException("Expected StringMessage type");
        StringMessage stringMessage = (StringMessage) message;

        if (!stringBuffer.equals(stringMessage.stringBuffer)) {
            return new Message[] { new StringMessage(this), new StringMessage(stringMessage) };
        } else {
            return new Message[] { new StringMessage(this.stringBuffer, this.stringCount + 1) };
        }
    }

    @Override
    public String getBody() {
        return getDecoratedString();
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
