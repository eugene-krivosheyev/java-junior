package com.acme.edu.message;

public class ArrayMessage extends LoggerMessage implements PrefixSupplier{
    private int[] array;
    private StringBuilder message;

    public ArrayMessage(int[] array) {
        this.array = array;
        message = new StringBuilder("{");
        fillStringWithArray();
        message.append("}");
    }

    private void fillStringWithArray() {
        for (int num : array) {
            message.append(num + ", ");
        }
        message.delete(message.length() - 2, message.length());
    }

    @Override
    public String getMessage() {
        return PREFIX_ARRAY + message;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}
