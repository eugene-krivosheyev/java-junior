package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.utils.ConsoleSaver;

public class CharMessage extends LoggerMessage{
    private char message;

    private String currentCharMessage = ""; // sum int

    ConsoleSaver consoleSaver = new ConsoleSaver();

    public CharMessage(char message) {
        super(MessageType.CHAR, MessagePrefix.CHAR_PREFIX);
        this.message = message;
    }

    @Override
    public void accumulateMessage(LoggerMessage charMessage) {
        currentCharMessage += ((CharMessage) charMessage).getMessage();
    }

    @Override
    public String createMessageWithPrefix() {
        return referencePrefix.getPrefixString() + currentCharMessage;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof CharMessage;
    }

    @Override
    public void printMessageBuffer() {
        if ("".equals(this.currentCharMessage)) return;
        consoleSaver.print(this.createMessageWithPrefix());
        this.currentCharMessage = "";
    }

    public char getMessage() {
        return message;
    }
}
