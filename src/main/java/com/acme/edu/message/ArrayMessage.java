package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.saver.Saver;

public class ArrayMessage extends LoggerMessage{
    private int[] intArray;

    private int[] currentIntArray = null;

    public ArrayMessage(int[] message) {
        super(MessageType.ARRAY, MessagePrefix.ARRAY_PREFIX);
        this.intArray = message;
    }

    @Override
    public void accumulateMessage(LoggerMessage intArray) {
        this.intArray = ((ArrayMessage) intArray).getMessage();
    }

    @Override
    public String createMessageWithPrefix() {
        String arrayString = "{";
        for (int i = 0; i < intArray.length-1; i++) {
            arrayString += intArray[i] + ", ";
        }
        arrayString += intArray[intArray.length-1] +"}";
        return referencePrefix.getPrefixString() + arrayString;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof ArrayMessage;
    }

    @Override
    public void printMessageBuffer(Saver saver) {
        saver.print(this.createMessageWithPrefix());
        this.currentIntArray = null;
    }

    public int[] getMessage() {
        return intArray;
    }
}
