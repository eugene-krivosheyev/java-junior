package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.utils.Saver;

public class MatrixMessage extends LoggerMessage{
    public int[][] matrix;

    private int[][] currentMatrix = null;

    public MatrixMessage(int[][] matrix) {
        super(MessageType.MATRIX, MessagePrefix.MATRIX_PREFIX);
        this.matrix = matrix;
    }

    @Override
    public void accumulateMessage(LoggerMessage matrix) {
        this.matrix = ((MatrixMessage) matrix).getMessage();
    }

    private String createArrayMessage(int[] intArray) {
        String arrayString = "{";
        for (int i = 0; i < intArray.length-1; i++) {
            arrayString += intArray[i] + ", ";
        }
        arrayString += intArray[intArray.length-1] +"}" + "\n";
        return arrayString;
    }

    @Override
    public String createMessageWithPrefix() {
        String lineArray = referencePrefix.getPrefixString() + "\n";
        for (int[] line : this.matrix) {
            lineArray +=  createArrayMessage(line);
        }
        lineArray += MessagePrefix.MATRIX_POSTFIX.getPrefixString();
        return lineArray;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof ArrayMessage;
    }

    @Override
    public void printMessageBuffer(Saver saver) {
        saver.print(this.createMessageWithPrefix());
        this.currentMatrix = null;
    }

    public int[][] getMessage() {
        return matrix;
    }
}
