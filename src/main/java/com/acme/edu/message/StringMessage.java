package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.utils.ConsoleSaver;

public class StringMessage extends LoggerMessage{
    private String message;

    private static String currentStringMessage = "";
    private static String lastStringMessage = "";
    private static int sameStringAmount = 0;

    ConsoleSaver consoleSaver = new ConsoleSaver();

    public StringMessage(String message) {
        super(MessageType.STRING, MessagePrefix.STRING_PREFIX);
        this.message = message;
    }

    @Override
    public void accumulateMessage(LoggerMessage message) {
        lastStringMessage = ((StringMessage) message).getMessage();
        currentStringMessage = ((StringMessage) message).getMessage();
        sameStringAmount++;
    }

    @Override
    public void printMessageBuffer() {
        if ("".equals(currentStringMessage)) return;
        consoleSaver.print(this.createMessageWithPrefix());
        currentStringMessage = "";
        lastStringMessage = "";
        sameStringAmount = 0;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return (message instanceof StringMessage) && ((StringMessage) message).getMessage().equals(lastStringMessage);
    }

    @Override
    public String createMessageWithPrefix() {
        if (sameStringAmount != 1) {
            currentStringMessage += " (x"+ sameStringAmount + ")";
        }
        return referencePrefix.getPrefixString() + currentStringMessage;
    }

    public String getMessage() {
        return message;
    }
}
