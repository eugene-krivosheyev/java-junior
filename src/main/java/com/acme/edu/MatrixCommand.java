package com.acme.edu;

public class MatrixCommand implements LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }

    @Override
    public void accumulate(LoggerMessage newMessage) {

    }
    /*StringBuilder message = new StringBuilder("{"+ lineSeparator());
        for(int i = 0; i < matrix[0].length; i++){
        message.append("{");
        fillStringWithArray(matrix[i], message);
        message.append("}" + lineSeparator());
    }
        message.append("}");
    writeMessage(PREFIX_MATRIX + message);*/
}
