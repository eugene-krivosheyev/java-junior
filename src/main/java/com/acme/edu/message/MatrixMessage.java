package com.acme.edu.message;

public class MatrixMessage extends LoggerMessage {
    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}



    /*StringBuilder message = new StringBuilder("{"+ lineSeparator());
        for(int i = 0; i < matrix[0].length; i++){
        message.append("{");
        fillStringWithArray(matrix[i], message);
        message.append("}" + lineSeparator());
    }
        message.append("}");
    writeMessage(PREFIX_MATRIX + message);*/

